package week2

// Playing around with objects

class Rational(x: Int, y: Int):
  private def numerator: Int = x
  private def denominator: Int = y

  def add(r: Rational) : Rational =
    Rational(
      numerator * r.denominator + r.numerator * denominator,
      denominator * r.denominator
    )

  override def toString = s"${numerator}/${denominator}"


val rat = Rational(2, 3)
val rat2 = Rational(4, 5)
val rat3 = rat add rat2

@main def testRational: Unit = println(rat3.toString())
