import scala.io.{BufferedSource, Source}
import scala.util.Using

def parse(input: BufferedSource): Seq[Seq[Int]] =
  input.getLines()
    .map(line => line.split(" ").map(_.toInt).toSeq)
    .toSeq

def isIncreasing(x: Int, y: Int): Boolean = y > x
def isDecreasing(x: Int, y: Int): Boolean = x > y
def isDifferByAtLeastOne(x: Int, y: Int): Boolean = math.abs(x - y) >= 1
def isDifferByAtMostThree(x: Int, y: Int): Boolean = math.abs(x - y) <= 3

def isReportSafe(report: Seq[Int]): Boolean = {
  report.sliding(2).foldLeft(true) {
    case (acc, Seq(current, next)) => acc && isIncreasing(current, next) && (isDifferByAtLeastOne(current, next) && isDifferByAtMostThree(current, next))
  } || report.sliding(2).foldLeft(true) {
    case (acc, Seq(current, next)) => acc && isDecreasing(current, next) && (isDifferByAtLeastOne(current, next) && isDifferByAtMostThree(current, next))
  }
}
def numSafeReports(reports: Seq[Seq[Int]]): Int = reports.count(isReportSafe)

def isDampenedSafe(report: Seq[Int]): Boolean =
  report.indices.exists { index =>
    val newLevels = report.take(index) ++ report.drop(index + 1)
    isReportSafe(newLevels)
  }
def numSafeDampenedReports(reports: Seq[Seq[Int]]): Int = reports.count(r => isReportSafe(r) || isDampenedSafe(r))

@main def solutionDay2(): Unit = {

  val filePath = "/home/olivertosky/personal/advent-of-code/2024/scala/adventofcode2024/src/resources/inputs/day2.txt"
  Using(Source.fromFile(filePath)) { source =>
    val reports = parse(source)

    val safeCount = numSafeReports(reports)
    println(safeCount) // 490

    val dampenedSafeCount = numSafeDampenedReports(reports)
    println(dampenedSafeCount) // 536
  }
}
