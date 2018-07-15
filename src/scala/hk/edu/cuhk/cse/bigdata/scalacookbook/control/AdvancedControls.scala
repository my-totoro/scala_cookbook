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

  // use if to implement ternary operators in Java
  def ifAsTernaryOperator(): Unit = {
    def abs(x: Int) = if(x >= 0) x else -x
    def max(x: Int, y: Int) = if(x >= y) x else y
  }

  // match statement
  case class Person(name: String)
  def getClassAsString(x: Any): String = x match {
    case s: String => s + "is a String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: List[_] => "List"
    case p: Person => "Person"
    case _ => "Unknow" // case default => println(default)
  }

  // match multiple conditions with one case
  def matchMultipleInOneCase(i: Int): Unit = i match {
    case 1 | 3 | 5 | 7 | 9 => println("Odd")
    case 2 | 4 | 6 | 8 | 10 => println("Even")
    case default => println(default)
  }

}
