package catsEffects

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits.catsSyntaxTuple2Semigroupal

import java.io._

object CopyFiles extends IOApp {

  private def transfer(origin: InputStream, destination: OutputStream, buffer: Array[Byte], acc: Long): IO[Long] =
    for {
      amount <- IO.blocking(origin.read(buffer, 0, buffer.length))
      count <- if (amount > -1) IO.blocking(destination.write(buffer, 0, amount)) >> transfer(origin, destination, buffer, acc + amount)
      else IO.pure(acc) // End of read stream reached (by java.io.InputStream contract), nothing to write
    } yield count // Returns the actual amount of bytes transferred

  def copy(origin: File, destination: File): IO[Long] = {
    val inIO: IO[InputStream] = IO.blocking(new FileInputStream(origin))
    val outIO: IO[OutputStream] = IO.blocking(new FileOutputStream(destination))

    (inIO, outIO) // Stage 1: Getting resources
      .tupled // From (IO[InputStream], IO[OutputStream]) to IO[(InputStream, OutputStream)]
      .bracket {
        case (in, out) =>
          transfer(in, out, new Array[Byte](1024 * 10), 0L) // Stage 2: Using resources (for copying data, in this case)
      } {
        case (in, out) => // Stage 3: Freeing resources
          (IO(in.close()), IO(out.close()))
            .tupled // From (IO[Unit], IO[Unit]) to IO[(Unit, Unit)]
            .void.handleErrorWith(_ => IO.unit)
      }
  }

  override def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- IO.raiseWhen(args.length < 2)(new IllegalArgumentException("Need origin and destination files"))
      orig = new File(args.head)
      dest = new File(args.tail.head)
      count <- copy(orig, dest)
      _ <- IO.println(s"$count bytes copied from ${orig.getPath} to ${dest.getPath}")
    } yield ExitCode.Success
}
