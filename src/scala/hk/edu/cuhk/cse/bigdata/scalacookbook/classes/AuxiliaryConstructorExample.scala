package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

// auxiliary constructor example
class AuxiliaryConstructorExample (var crustSize: Int, var crustType: String) {
  def this(crustSize: Int) = {
    this(crustSize, "Big")
  }
  def this(crustType: String) = {
    this(10, crustType)
  }

}

case class Person(var name: String, var age: Int)
object Person {
  // auxiliary constructors for case classes
  def apply() = new Person("no name", 10)
  def apply(name: String) = new Person(name, 10)
}
