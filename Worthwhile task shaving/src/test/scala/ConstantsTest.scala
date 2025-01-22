import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ConstantsTest extends AnyFlatSpec with Matchers {

  behavior of "secondsInMinute"

  it should "initialized correctly" in {
    Main.secondsInMinute should be(60)
  }

  behavior of "secondsInHour"

  it should "initialized correctly" in {
    Main.secondsInHour should be(Main.secondsInMinute * 60)
  }

  behavior of "secondsInDay"

  it should "initialized correctly" in {
    Main.secondsInDay should be(Main.secondsInHour * 24)
  }

  behavior of "secondsInWeek"

  it should "initialized correctly" in {
    Main.secondsInWeek should be(Main.secondsInDay * 7)
  }

  behavior of "secondsInYear"

  it should "initialized correctly" in {
    Main.secondsInYear should be(Main.secondsInDay * Main.daysInAYear)
  }

  behavior of "secondsInMonth"

  it should "initialized correctly" in {
    Main.secondsInMonth should be(Main.secondsInYear / 12)
  }

  behavior of "daysInAYear"

  it should "initialized correctly" in {
    Main.daysInAYear should be(365.25)
  }
}
