package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

class InheritExample {

  // primary constructor
  class Person(var name: String, var age: Int) {
    // auxiliary constructor
    def this(name: String) = {
      this(name, 20)
    }
    override def toString: String = "A person"
  }

  // inherit name and age without var or val
  // call super two arg primary constructor
  class Employee(name: String, age: Int, var location: String) extends Person(name, age) {
    var income: Int = _

    // auxiliary constructor cannot control which constructor of super class to call
    def this(name: String) = {
      this(name, 10, "NY")
    }
  }
}
