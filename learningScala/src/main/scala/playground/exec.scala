package playground

import algorithmsSpecialization.course1.mergeSort

object exec extends App {
  val sorted = mergeSort.mergeSort(Array(10, 15, 0, 2, 15))
  println(sorted.mkString("Array(", ", ", ")"))
}
