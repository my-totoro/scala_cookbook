package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

// primary constructor examples
class PrimaryConstructorExample (var variable1: String, var variable2: String,
                                 val notChangeable: String, notAccessible: String,
                                 private var name: String) {
  println("Constructor begins:")
  def printVar1(): Unit = {println(s"variable1 = $variable1")}
  def printVar2(): Unit = {println(s"variable2 = $variable2")}

  printVar1()
  printVar2()
}

object TestPrimaryConstructorExample {
  def main(args: Array[String]): Unit = {
    val p = new PrimaryConstructorExample("Adam", "Meyer",
      "Jack", "NotAccessible", "Alvin")
    println(p.variable1)
    println(p.variable2)
    println(p.notChangeable)
    p.variable2 = "Meyer2"
    println(p.variable2)
//    println(p.notAccessible)
//    p.notChangeable = "Error"
//    println(p.name)
  }
}