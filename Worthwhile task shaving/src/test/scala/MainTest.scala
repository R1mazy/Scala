
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MainTest extends AnyFlatSpec with Matchers {

  behavior of "getShaveString"

  it should "return empty string when both arguments are zero" in {
    val result = Main.getShaveString(0.0, "")
    result should be("                  ")
  }

  it should "return correctly formatted string for singular intervals" in {
    val result = Main.getShaveString(1.0, "hour")
    result should be("            1 hour")
  }

  it should "return correctly formatted string for plural intervals" in {
    val result = Main.getShaveString(2.0, "day")
    result should be("            2 days")
  }

  it should "round down non-integer values" in {
    val result = Main.getShaveString(1.9, "month")
    result should be("          1 months")
  }
}
