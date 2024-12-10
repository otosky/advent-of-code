import scala.io.{BufferedSource, Source}
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
    def parse(input: BufferedSource): String = input.mkString

    val filePath =
        "/home/olivertosky/personal/advent-of-code/2024/scala/adventofcode2024/src/resources/inputs/day3.txt"
    Using(Source.fromFile(filePath)) { source =>
        val rawText = parse(source)

        println(part1(rawText))

    }
}
