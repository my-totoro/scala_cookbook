package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

// private primary constructor for defining singleton
class PrivatePrimaryConstructor private {
  override def toString: String = "This is a private primary constructor example."

}

// functions in object are static and can be called directly
object PrivatePrimaryConstructor {
  val constructor = new PrivatePrimaryConstructor
  def getInstance: PrivatePrimaryConstructor = constructor
}

object SingletonTest {
  def main(args: Array[String]): Unit = {
    val example = PrivatePrimaryConstructor.getInstance
    print(example)
  }

}