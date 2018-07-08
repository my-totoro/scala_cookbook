package hk.edu.cuhk.cse.bigdata.scalacookbook.strings

import scala.util.matching.Regex

/**
  * This class gives some examples on string operations.
  */
object StringOperations {
  def main(args: Array[String]): Unit = {
    equalStrings()
    multiLineStrings()
    splitStrings()
    variableInStrings()
    processCharInStrings()
    searchInStrings()
    replaceInStrings()
    extractFromStrings()
    accessCharInStrings()
    userDefinedFunctions()
  }

  // compare two strings
  def equalStrings(): Unit = {
    val s1 = "Marisa"
    val s2 = "marisa"
    println(s1==s2)
    println(s1.equalsIgnoreCase(s2))
    println(s1.toUpperCase == s2.toUpperCase)
  }

  // format multi-line strings
  def multiLineStrings(): Unit ={
    val s1 =
      """
        |This is a multi-line
        |string.
      """.stripMargin
    val s2 =
      """
        #This is a multi-line
        #string.
      """.stripMargin('#')
    val s3 =
      """
        |This is one line
        |string.
      """.stripMargin.replaceAll("\r\n", " ")

    println(s1)
    println(s2)
    println(s3)
  }

  // split strings
  def splitStrings(): Unit = {
    val s1 = "eggs, milk, butter"
    val s2 = s1.split(",").map(_.trim)
    val s3 = s1.split("\\s+")
    println(s1)
    s2.foreach(println)
    s3.foreach(println)

  }

  // substitute variables in strings
  def variableInStrings(): Unit = {
    val age = 28
    val name = "John"
    val weight = 70.5
    println(s"$name is $age years old and weights $weight kg.")
    println(s"$name is $age years old and weights ${weight + 3} kg.")
    println(f"$name is $age years old and weights $weight%.2f kg")
    println(s"foo\nbar")
    println(raw"foo\nbar")
  }

  // process each character in strings
  def processCharInStrings(): Unit = {
    val s1 = "hello, world"
    val s2 = s1.map(_.toUpper)
    val s3 = s1.filter(_ != 'l').map(_.toUpper)
    val s4 = for(c <- s1) yield c.toUpper
    val s5 = s1.getBytes
    println(s2)
    println(s3)
    println(s4)
    s5.foreach(println)
  }

  // search patterns in strings
  def searchInStrings(): Unit = {
    val pattern = "[0-9]+".r
    val patternObject = new Regex("[0-9]+")
    val s1 = "123 Main Street Suite 101"
    val match1 = pattern.findFirstIn(s1).getOrElse("no match")
    val match2 = pattern.findAllIn(s1)
    val match3 = patternObject.findFirstIn(s1)

    match3 match {
      case Some(s) => println(s"Found: $s")
      case None => println("Not found.")
    }


  }

  // search patterns in strings
  def replaceInStrings(): Unit = {
    val address = "123 Main Street Suite 101".replaceAll("[0-9]+", "x")
    val pattern = "[0-9]+".r
    val newAddress = pattern.replaceAllIn("123 Main Street Suite 101", "x")
    println(address)
    println(newAddress)
  }

  // extract parts from strings based on regex
  def extractFromStrings(): Unit = {
    val pattern = "([0-9]+) ([A-Za-z]+)".r
    val pattern(age, name) = "30 John"
    println(age)
    println(name)
  }

  // access chars in strings
  def accessCharInStrings(): Unit = {
    val s1 = "hello"
    val s2 = s1.charAt(0)
    val s3 = s1(0)
    val s4 = s1.apply(1)
    println(s2, s3, s4)
  }

  // add new functionality on existing strings
  implicit class StringImprovements(val s: String) {
    def increment: String = s.map(c => (c+1).toChar)
    def decrement: String = s.map(c => (c-1).toChar)
    def plusOne: Int = s.toInt + 1
    def asBoolean: Boolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }

  // use some user-defined functions
  def userDefinedFunctions(): Unit = {
    val s1 = "hello"
    val s2 = s1.increment
    println(s2)
    println("1".plusOne)
    println("0".asBoolean)

  }
}


