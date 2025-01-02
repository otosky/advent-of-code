package day02

import scala.io.{BufferedSource, Source}
import scala.util.Using

type Report = Seq[Int]

def isSafe(report: Report): Boolean = {
    val diffs = report.sliding(2).map(pair => pair(1) - pair(0))
    if report.head < report.last then
        diffs.forall(d => 1 <= d && d <= 3) // ascending
    else if report.head > report.last then
        diffs.forall(d => -3 <= d && d <= -1) // descending
    else false
}
def numSafeReports(reports: Seq[Report]): Int = reports.count(isSafe)

def dampen(report: Report): Seq[Report] =
    report.to(LazyList).zipWithIndex.map((_, i) => report.patch(i, Nil, 1))
def isAlmostSafe(report: Report): Boolean = dampen(report).exists(isSafe)
def numSafeDampenedReports(reports: Seq[Report]): Int =
    reports.count(r => isSafe(r) || isAlmostSafe(r))

@main def solutionDay2(): Unit = {
    def parse(input: BufferedSource): Seq[Report] =
        input
            .getLines()
            .map(line => line.split(" ").map(_.toInt).toVector)
            .toSeq

    Using(Source.fromResource("inputs/day02.txt")) { source =>
        val reports = parse(source)

        val safeCount = numSafeReports(reports)
        println(safeCount) // 490

        val dampenedSafeCount = numSafeDampenedReports(reports)
        println(dampenedSafeCount) // 536
    }
}
