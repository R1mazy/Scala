object Main {

  val rowNames = Array(
    " 1 Second",
    " 5 Seconds",
    "30 Seconds",
    " 1 Minute",
    " 5 Minutes",
    "30 Minutes",
    " 1 Hour",
    " 6 Hours",
    " 1 Day"
  )

  val rowValuesInSeconds = Array(1, 5, 30, 60, 300, 1800, 3600, 21600, 86400)
  val daysInAYear = 365.25

  val secondsInMinute = 60
  val secondsInHour = secondsInMinute * 60
  val secondsInDay = secondsInHour * 24
  val secondsInWeek = secondsInDay * 7
  val secondsInYear = secondsInDay * daysInAYear
  val secondsInMonth = secondsInYear / 12

  val columnNames = Array(
    "    Shaved-off |",
    "           50/Day",
    "            5/Day",
    "            Daily",
    "           Weekly",
    "          Monthly",
    "           Yearly"
  )

  val shavesPerYear = Array(
    50 * daysInAYear,
    5 * daysInAYear,
    daysInAYear,
    daysInAYear / 7,
    12,
    1
  )

  def getShaveString(amountOfInterval: Double, interval: String): String = {
    if (amountOfInterval == 0.0 && interval == "") {
      " ".padLeft(18)
    } else {
      val pluralString = if (amountOfInterval > 1) "s" else ""
      val result = s"${amountOfInterval.toInt} $interval$pluralString"
      result.padLeft(18)
    }
  }

  implicit class StringOps(s: String) {
    def padLeft(n: Int): String = {
      " " * (n - s.length) + s
    }

    def padRight(n: Int): String = {
      s + " " * (n - s.length)
    }
  }

  def main(args: Array[String]): Unit = {
    println(" " * 34 + "How Often You Do the Task\n")

    for (columnName <- columnNames) {
      print(columnName.padLeft(14) + " ")
    }

    println()
    println("-" * 124)

    for ((rowName, rowNumber) <- rowNames.zipWithIndex) {
      var row = rowName.padLeft(14) + " |"

      for (columnValue <- shavesPerYear.indices) {
        val t = shavesPerYear(columnValue) * rowValuesInSeconds(rowNumber) * 5
        val (amountOfInterval, interval) = t match {
          case t if t < secondsInMinute => (t, "Second")
          case t if t < secondsInHour => (t / secondsInMinute, "Minute")
          case t if t < secondsInDay => (t / secondsInHour, "Hour")
          case t if t < secondsInWeek * 2 => (t / secondsInDay, "Day")
          case t if t < secondsInMonth * 2 => (t / secondsInWeek, "Week")
          case t if t < secondsInYear => (t / secondsInMonth, "Month")
          case _ =>
            (0.0, "")
        }
        row += getShaveString(amountOfInterval, interval)
      }
      println(row)
    }
  }
}
