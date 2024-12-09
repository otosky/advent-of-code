import scala.io.{BufferedSource, Source}
import scala.util.Using

def parse(input: BufferedSource): Seq[Vector[Int]] =
  input.getLines()
    .map(line => line.split(" ").map(_.toInt).toVector)
    .toSeq

def isSafe(report: Seq[Int]): Boolean = {
  val diffs = report.sliding(2).map(pair => pair(1) - pair(0))
  if report.head < report.last then diffs.forall(d => 1 <= d && d <= 3) // ascending
  else if report.head > report.last then diffs.forall(d => -3 <= d && d <= -1) // descending
  else false
}
def numSafeReports(reports: Seq[Seq[Int]]): Int = reports.count(isSafe)

def dampen(report: Seq[Int]): Seq[Seq[Int]] =
  for i <- LazyList.from(report.indices) yield report.patch(i, Nil, 1) // report.take(i) ++ report.drop(i + 1)
def isAlmostSafe(report: Seq[Int]): Boolean = dampen(report).exists(isSafe)
def numSafeDampenedReports(reports: Seq[Seq[Int]]): Int =
  reports.count(r => isSafe(r) || isAlmostSafe(r))

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
