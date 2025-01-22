import org.scalatest.funsuite.AnyFunSuite

class LogicTest extends AnyFunSuite {

  test("shaves per year are calculated correctly") {
    assert(Main.shavesPerYear.mkString(", ") === "18262.5, 1826.25, 365.25, 52.17857142857143, 12.0, 1.0")
  }

  test("time conversion works correctly for small intervals") {
    val (amountOfInterval, interval) = convertTimeToInterval(120)
    assert((amountOfInterval, interval) === (2.0, "Minute"))
  }

  test("time conversion works correctly for large intervals") {
    val (amountOfInterval, interval) = convertTimeToInterval(2592000)
    assert((amountOfInterval, interval) === (4.0, "Week"))
  }

  def convertTimeToInterval(t: Int): (Double, String) = {
    t match {
      case t if t < Main.secondsInMinute => (t, "Second")
      case t if t < Main.secondsInHour => (t / Main.secondsInMinute, "Minute")
      case t if t < Main.secondsInDay => (t / Main.secondsInHour, "Hour")
      case t if t < Main.secondsInWeek * 2 => (t / Main.secondsInDay, "Day")
      case t if t < Main.secondsInMonth * 2 => (t / Main.secondsInWeek, "Week")
      case t if t < Main.secondsInYear => (t / Main.secondsInMonth, "Month")
      case _ =>
        (0.0, "")
    }
  }
}