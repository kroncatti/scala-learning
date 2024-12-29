package week1

import scala.annotation.tailrec

def square(x: Double): Double = x * x
def abs(x: Double): Double = if (x > 0) x else -x


def sqrt(x: Double) = {
  // Block with definitions

  @tailrec
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess))
      guess
    else
      sqrtIter(improve(guess), x)

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double) =
    abs(square(guess) - x) < 0.001

  sqrtIter(1.0, x)
}

@main def test: Unit = println(sqrt(2))
