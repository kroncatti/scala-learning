package week2

import scala.annotation.tailrec

// Linear recursion version
def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum((x: Int) => x, a, b)

// Tail recursion version
def sumTR(f: Int => Int, a: Int, b: Int): Int =
  @tailrec
  def loop(a: Int, acc: Int): Int =
    if a > b then acc
    else loop(a + 1, acc + f(a))
  loop(a, 0)

def sumCubes(a: Int, b: Int) = sumTR((x: Int) => x * x * x, a, b)

@main def test: Unit = println(sumCubes(2, 4))
