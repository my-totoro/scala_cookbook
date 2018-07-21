package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

// First choice is trait, two situations for abstract classes:
// 1. require constructor parameters
// 2. to be called by Java code
class AbstractClass {

  case class Database()

  abstract class BaseController(db: Database) {
    val name: String
    var status: Boolean
    var owner = "Bigdata"

    def save(): Unit = {
      println(db.toString)
    }

    // abstract method
    def connect: String

  }

  class Controller(db: Database) extends BaseController(db) {
    // need val or var
    val name = "Bigdata"
    var status: Boolean = true
    // no need with var as it has been initialized in base class
    owner = "CSE"
    override def connect: String = "Connected"

  }

}
