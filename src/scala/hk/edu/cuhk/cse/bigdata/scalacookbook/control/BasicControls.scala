package hk.edu.cuhk.cse.bigdata.scalacookbook.control

import scala.util.control.Breaks.{breakable, break}
import scala.util.control.Breaks

object BasicControls {
  def main(args: Array[String]): Unit = {

    iterateOverElements()
    loopWithMultipleCounters()
    loopWithGuards()
    loopWithBreakContinue()
  }

  // iterate elements in sequence
  def iterateOverElements(): Unit = {
    val arr = Array("apple", "banana", "orange")
    val names = Map("fname" -> "Robert", "lname" -> "Goren")
    for(element <- arr) println(element)
    val newArr = for(element <- arr) yield element.toUpperCase
    for((element, count) <- arr.zipWithIndex) {
      println(s"$count is $element")
    }
    for((k, v) <- names) {
      println(s"key: $k, value: $v")
    }
    for(i <- 1 to 10 if i < 4) println(i)
  }

  // for loop with multiple counters
  def loopWithMultipleCounters(): Unit = {
    for(i <- 0 to 2; j <- 0 to 3) println(s"i = $i, j = $j")
    for{
      i <- 0 to 2
      j <- 0 to 3
      k <- 0 to 4
    } println(s"i = $i, j = $j, k = $k")
  }

  // for loop with conditions
  def loopWithGuards(): Unit = {
    for{
      i <- 0 to 2
      j <- 0 to 4
      if i % 2 == 0
    } println(s"i = $i, j = $j")
  }

  //break and continue in loops
  def loopWithBreakContinue(): Unit = {
    // break
    breakable{
      for(i <- 1 to 10) {
        println(i)
        if(i > 4) break
      }
    }

    // continue
    for(i <- 0 to 10) {
      breakable{
        if(i == 4) break
        else println(s"i = $i")
      }
    }

    // nested break
    val Inner = new Breaks
    val Outer = new Breaks
    Outer.breakable{
      for(i <- 1 to 5) {
        Inner.breakable{
          for(j <- 'a' to 'e') {
            if(i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")
            if(i == 2 && j == 'b') Outer.break
          }
        }
      }
    }
  }

}
