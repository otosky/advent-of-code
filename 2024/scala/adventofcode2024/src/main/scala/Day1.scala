import scala.io.{BufferedSource, Source}
import scala.util.Using

def getDistance(l1: Seq[Long], l2: Seq[Long]): Long =
    val distances = l1.zip(l2).map((left, right) => math.abs(left - right))
    distances.sum

def getSimilarity(l1: Seq[Long], l2: Seq[Long]): Long =
    val countMap: Map[Long, Long] =
        l2.groupBy(identity).view.mapValues(_.size.toLong).toMap

    val counts = l1.map(elem => countMap.getOrElse(elem, 0L) * elem)
    counts.sum

@main def solution(): Unit =
    def parse(input: BufferedSource): (Seq[Long], Seq[Long]) =
        val pairs = input
            .getLines()
            .map(line => line.split("   ").map(_.toLong))
            .toSeq

        val lefts = pairs.map(_.head).toSeq.sorted
        val rights = pairs.map(_.last).toSeq.sorted
        (lefts, rights)

    val filePath =
        "/home/olivertosky/personal/advent-of-code/2024/scala/adventofcode2024/src/resources/inputs/day1.txt"

    Using(Source.fromFile(filePath)) { source =>
        val (l1, l2) = parse(source)

        val distance = getDistance(l1, l2)
        println(distance) // 3714264

        val similarity = getSimilarity(l1, l2)
        println(similarity) // 414
    }
