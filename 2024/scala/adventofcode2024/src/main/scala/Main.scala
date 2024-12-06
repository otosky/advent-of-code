import scala.io.{BufferedSource, Source}
import scala.util.Using


def getDistanceBetweenLists(l1: Seq[Long], l2: Seq[Long]): Long =
  l1.zip(l2).map(_ - _).map(_.abs).sum

def parse(input: BufferedSource): (Seq[Long], Seq[Long]) =
  val pairs = input
    .getLines()
    .map(line => line.split("   ").map(_.toLong))
    .toSeq

  val lefts = pairs.map(_.head).toSeq.sorted
  val rights = pairs.map(_.last).toSeq.sorted
  (lefts, rights)

@main def solution(): Unit =
  val filePath = "/home/olivertosky/personal/advent-of-code/2024/scala/adventofcode2024/src/resources/inputs/day1.txt"
  Using(Source.fromFile(filePath)) { source =>
    val (l1, l2) = parse(source)
    println(getDistanceBetweenLists(l1, l2)) // 3714264
  }

