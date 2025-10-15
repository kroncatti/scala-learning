package fpPrinciplesCourse.week2

import scala.annotation.tailrec

val tolerance = 0.0001
def abs(x: Double): Double = if (x > 0) x else -x

def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double): Double =
  @tailrec
  def iterate(guess: Double): Double =
    val next = f(guess)
    println(next)
    if isCloseEnough(guess, next) then next
    else iterate(next)
  iterate(firstGuess)

// sqrt(x) ===> y * y = x ===> y = x / y ===> sqrt(x) = x / sqrt(x)

/* The following would diverge due to oscillations issue
def sqrt(x: Double) =
  fixedPoint(y => x / y)(1.0)
*/

// Using an average damping to avoid divergence
def sqrt(x: Double) =
  fixedPoint(y => (y + x / y) / 2)(1.0)

@main def testFixedPoint: Unit = sqrt(2)