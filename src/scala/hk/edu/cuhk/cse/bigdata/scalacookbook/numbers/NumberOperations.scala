package hk.edu.cuhk.cse.bigdata.scalacookbook.numbers

import scala.util.Random
import scala.math.Pi
import java.text.NumberFormat.getIntegerInstance
import java.text.NumberFormat.getCurrencyInstance
import java.util.{Currency, Locale}

object NumberOperations {
  def main(args: Array[String]): Unit = {
    parseNumbers()
    generateRandom()
    formatNumbers()
  }

  // parse numbers from strings
  def parseNumbers(): Unit = {
    val num1 = "10".toInt
    val num2 = Integer.parseInt("10", 8)
    val num3 = 10.34.toInt
    println(num1)
    println(num2)
    println(num3)
    println(num3.isValidByte)
  }

  // generate random numbers
  def generateRandom(): Unit = {
    val random = Random
    val randomInt = Random.nextInt(100)
    val randomChar = Random.nextPrintableChar()
    val randomArray = for(i <- 0 to random.nextInt(10)) yield i * random.nextDouble
    println(randomInt)
    println(randomChar)
    println(randomArray)
  }

  // format numbers and currency
  def formatNumbers(): Unit = {
    val pi = Pi
    println(f"$pi%1.5f")
    val formatter = getIntegerInstance
    println(formatter.format(10000))
    val de = Currency.getInstance(new Locale("cn", "CN"))
    val formatter2 = getCurrencyInstance
    formatter2.setCurrency(de)
    println(de)
    println(formatter2.format(12345.67))

  }

}
