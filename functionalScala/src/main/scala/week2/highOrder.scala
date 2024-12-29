package week2

import scala.annotation.tailrec

// Linear recursion version
def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum((x: Int) => x, a, b)

// Tail recursion version (Cheaper)
def sumTR(f: Int => Int, a: Int, b: Int): Int =
  @tailrec
  def loop(a: Int, acc: Int): Int =
    if a > b then acc
    else loop(a + 1, acc + f(a))
  loop(a, 0)

// def sumCubes(a: Int, b: Int) = sumTR((x: Int) => x * x * x, a, b)

// Going deeper and using currying
// This will hide a/b and the sum function will return another function.
def sumCurrying(f: Int => Int): (Int, Int) => Int =
  def sumF(a: Int, b: Int) : Int =
    if a > b then 0
    else f(a) + sumF(a + 1, b)
  sumF

def sumCubes = sumCurrying((x: Int) => x * x * x)

@main def test: Unit = println(sumCubes(2, 4))
