package catsEffects

import cats.effect.{IO, IOApp}
import scala.concurrent.duration._


object HelloWorld extends IOApp.Simple {
  lazy val loop: IO[Unit] = IO.println("Hello, World!") >> loop


  val run: IO[Unit] = loop.timeout(2.seconds)
}