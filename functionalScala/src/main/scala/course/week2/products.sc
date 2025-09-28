def product(f: Int => Int)(a: Int, b: Int): Int =
  if a > b then 1 else f(a) * product(f)(a + 1, b)

product(x => x * x)(1, 5)

def factorial(n: Int) = product(x => x)(1, n)

factorial(5)

// MAP REDUCE APPROACH
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int) : Int =
  def recur(a: Int) : Int =
    if a > b then zero
    else combine(f(a), recur(a + 1))
  recur(a)

def sum(f: Int => Int) = mapReduce(f, (x, y) => x + y, 0)

sum(x => x)(2, 4)

def productNew(f: Int => Int) = mapReduce(f, (x, y) => x * y, 1)

def newFactorial(value: Int) = productNew(x => x)(1, value)