import scala.io.Source
import scala.util.Using


def getDistanceBetweenLists(l1: List[Int], l2: List[Int]): Int =
  l1.sorted().zip(l2.sorted()).map(_ - _).map(_.abs).sum

@main def solution(): Unit =
  val filePath = "/home/olivertosky/personal/advent-of-code/2024/scala/adventofcode2024/src/resources/inputs/day1.txt"
  Using(Source.fromFile(filePath)) { source =>
    val parsed = for {
      line <- source.getLines()
      parts = line.split("\\s+") if parts.length >= 2
    } yield (parts(0).toInt, parts(1).toInt)
    val (l1, l2) = parsed.toList.unzip
    println(getDistanceBetweenLists(l1, l2))
  }

