package adventofcode2024.day3

import scala.io.Source
import scala.util.Using

def part1(s: String): Int =
    val pattern = """mul\((\d{1,3}),(\d{1,3})\)""".r
    val pairs =
        for matchGroup <- pattern.findAllMatchIn(s)
        yield (matchGroup.group(1).toInt, matchGroup.group(2).toInt)

    pairs.map(_ * _).sum

def part2(s: String): Int =
    val pattern = """mul\((\d{1,3}),(\d{1,3})\)""".r
    val fullPattern = """(mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\))""".r
    val occurences = fullPattern.findAllIn(s)

    val (_, result) = occurences.foldLeft((true, 0)) {
        case ((true, acc), pattern(x, y)) => (true, acc + (x.toInt * y.toInt))
        case ((_, acc), "don't()")        => (false, acc)
        case ((_, acc), "do()")           => (true, acc)
        case ((flag, acc), _)             => (flag, acc)
    }
    result

@main def solutionDay3(): Unit = {
    Using(Source.fromResource("inputs/day3.txt")) { source =>
        val rawText = source.mkString

        println(part1(rawText))
        println(part2(rawText))
    }
}
