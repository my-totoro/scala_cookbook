package hk.edu.cuhk.cse.bigdata.scalacookbook.classes

class FieldExamples {
  // getter and setter are generated
  var price: Double = _

  // keep this field from other classes, but can accessed by other instances of this class
  private var currentPrice: Double = _

  // can only be accessed by current instance
  private[this] var predictedPrice: Double = _

  // lazy means it is only evaluated when needed
  lazy val text: String = {
    var lines = ""
    try {
      lines = io.Source.fromFile("/etc/passwd").getLines.mkString
    } catch {
      case e: Exception => lines = "Error happened"
    }
    lines
  }

  case class Address(city: String, state: String)

  // initialize with an option
  var address: Option[Address] = None

  def printAddress(): Unit = {
    address.foreach(a => {
      println(a.city)
      println(a.state)
    })
  }

  def setPredictedPrice(p: Double): Unit = {
    predictedPrice = p
  }


}
