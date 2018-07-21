package hk.edu.cuhk.cse.bigdata.scalacookbook.control

import java.io.{FileInputStream, FileOutputStream, IOException}

object MoreAdvancedControls {

  def main(args: Array[String]): Unit = {
    println(differentMatchPattern(0))

  }

  case class Person(firstName: String, lastName: String)
  case class Dog(name: String)

  // pattern match
  def differentMatchPattern(x: Any): String = x match {
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "You said hello"
    case Nil => "an empty list"

    // sequence patterns
    case List(0, _, _) => "A three element list starting with 0"
    case List(1, _*) => "A list beginning with 1, having any number of elements"
    case Vector(1, _*) => "A vector starting with 1, having any number of elements"

    // tuple patterns
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b, and $c"

    // constructor patterns
    case Person(first, "Alex") => s"found an Alex, first name = $first"
    case Dog("Suka") => "found a dog named Suka"

    // typed patterns
    case s: String => s"You give me this string: $s"
    case i: Int => s"You give me this int: $i"
    case f: Float => s"You give me this float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
    case list: List[_] => s"a list: $list"
    case m: Map[_, _] => m.toString

    // adding variables in patterns
    case list @ List(1, _*) => s"$list"
    case s @ Some(_) => s"$s"

    // default
    case _ => "Unknow"


  }

  // match with guards
  def mathWithGuards(x: Any): Unit = x match {
    case a if 0 to 9 contains a => println("0-9 range: " + a)
    case b if 10 to 19 contains b => println("10-19 range: " + b)
    case _ => println("Hmm...")
  }

  //declare variables before try/catch/finally
  def variableBeforeTry(): Unit = {
    var in = None: Option[FileInputStream]
    var out = None: Option[FileOutputStream]

    try{
      in = Some(new FileInputStream("/tmp/some.txt"))
      out = Some(new FileOutputStream("/tmp/other.txt"))
      var c = 0
      while({c = in.get.read; c != -1}) {
        out.get.write(c)
      }
    } catch {
      case e: IOException => e.printStackTrace()
    } finally {
      println("entered finally...")
      if(in.isDefined) in.get.close()
      if(out.isDefined) out.get.close()
    }
  }

}
