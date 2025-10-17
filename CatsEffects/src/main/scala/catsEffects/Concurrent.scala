package catsEffects

import cats.effect.{IO, IOApp}


object Concurrent extends IOApp.Simple {
  def myFunction: IO[Unit] = {
    (IO(println("Hello, World!")), IO.println("Hello, people!")).parTupled >> IO.println("final")
  }

  val run: IO[Unit] = myFunction
}