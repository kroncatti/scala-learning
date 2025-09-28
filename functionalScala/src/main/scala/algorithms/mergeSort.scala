package algorithms


object mergeSort extends App {
  private def mergePreSortedArrays(a: Array[Int], b: Array[Int]): Array[Int] =
    val respArray = new Array[Int](a.length + b.length)
    var i = 0
    var j = 0
    var k = 0

    while (i < a.length && j < b.length) {
      if (a(i) <= b(j)) {
        respArray(k) = a(i)
        i += 1
      } else {
        respArray(k) = b(j)
        j += 1
      }
      k += 1
    }

    // Remaining elements
    while (i < a.length) {
      respArray(k) = a(i)
      i += 1
      k += 1
    }
    while (j < b.length) {
      respArray(k) = b(j)
      j += 1
      k += 1
    }
    respArray

  def mergeSort(array: Array[Int]): Array[Int] = {
    val mid = array.length / 2
    if (mid == 0) array
    else {
      val (left, right) = array.splitAt(mid)
      mergePreSortedArrays(mergeSort(left), mergeSort(right))
    }
  }
}