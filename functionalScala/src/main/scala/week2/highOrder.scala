package week2

import scala.annotation.tailrec

//
// HIGH ORDER FUNCTIONS
//

// Linear recursion version
def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)

def sumInts(a: Int, b: Int) = sum((x: Int) => x, a, b)

//
// TAIL RECURSION VERSION
//

def sumTR(f: Int => Int, a: Int, b: Int): Int =
  @tailrec
  def loop(a: Int, acc: Int): Int =
    if a > b then acc
    else loop(a + 1, acc + f(a))
  loop(a, 0)

def sumCubes(a: Int, b: Int) = sumTR((x: Int) => x * x * x, a, b)

//
// CURRYING MECHANISM
//

// This will hide a/b and the sum function will return another function.
def sumCurrying(f: Int => Int): (Int, Int) => Int =
  def sumF(a: Int, b: Int) : Int =
    if a > b then 0
    else f(a) + sumF(a + 1, b)
  sumF

def sumCubesCurrying = sumCurrying((x: Int) => x * x * x)

// Shorter version of currying using a multi-parameter list and "jumping" some steps
def sumMultipleParameters(f: Int => Int)(a: Int, b: Int): Int =
  if a > b then 0 else f(a) + sumMultipleParameters(f)(a + 1, b)

@main def test: Unit = println(sumMultipleParameters(x => x * x * x)(2, 4))
