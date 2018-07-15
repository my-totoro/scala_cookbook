package hk.edu.cuhk.cse.bigdata.scalacookbook.control

import scala.annotation.tailrec

object AdvancedControls {
  def main(args: Array[String]): Unit = {
    testFactorial()
  }

  // tailrec for high performance
  private def factorial(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if(n <= 1) acc
      else factorialAcc(n * acc, n - 1)
    }
    factorialAcc(1, n)
  }

  def testFactorial(): Unit = {
    println(factorial(10))
  }

}
