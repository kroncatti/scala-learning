package week2

// Playing around with objects

class Rational(x: Int, y: Int):
  private def numerator: Int = x
  private def denominator: Int = y

  def add(r: Rational): Rational =
    Rational(
      numerator * r.denominator + r.numerator * denominator,
      denominator * r.denominator
    )

  def multiply(r: Rational): Rational =
    Rational(
      numerator * r.numerator,
      denominator * r.denominator
    )

  override def toString = s"${numerator}/${denominator}"
  
end Rational


val rat = Rational(2, 3)
val rat2 = rat add Rational(1, 3)
val rat3 = rat2 multiply Rational(2, 4)

@main def testRational: Unit = println(rat3.toString())
