package day02

import scala.io.Source
import scala.util.{Success, Failure, Using}

def parse(input: Iterator[String]): Seq[(String, String)] =
    input
        .flatMap(_.split(","))
        .map(_.trim)
        .map { range =>
            val parts = range.split("-")
            (parts(0), parts(1))
        }
        .toSeq

def findInvalidIds(ranges: Seq[(String, String)]): Seq[Long] =
    for {
        (start, end) <- ranges
        num <- start.toLong to end.toLong
        if isInvalidId(num.toString)
    } yield num

def isInvalidId(v: String): Boolean = {
    if (v.length % 2 != 0) false
    else {
        val (left, right) = v.splitAt(v.length / 2)
        left == right
    }
}

def sumInvalidIds(ranges: Seq[(String, String)]): Long =
    findInvalidIds(ranges).sum

@main def solution(): Unit = {
    Using(Source.fromResource("inputs/day02.txt")) { source =>
        val lines = parse(source.getLines())
        lines.foreach(println)

        val solution1 = sumInvalidIds(lines)
        println(s"Part1 Solution: ${solution1}")

    } match {
        case Success(_) => println("Success!")
        case Failure(e) => println(s"Error: ${e.getMessage}")
    }
}
