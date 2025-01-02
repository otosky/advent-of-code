package day04

import scala.io.Source
import scala.util.Using

case class Size(width: Int, height: Int)

/* think moving southwest */
def rightDiagonal(size: Int, xss: Seq[Seq[Char]]): Iterator[Seq[Char]] = for
    y <- (0 to xss.size - size).iterator
    x <- (size - 1 until xss.head.size).iterator
yield (for i <- 0 until size yield xss(y + i)(x - i))

/* think moving southeast */
def leftDiagonal(size: Int, xss: Seq[Seq[Char]]): Iterator[Seq[Char]] = for
    y <- (0 to xss.size - size).iterator
    x <- (0 to xss.head.size - size).iterator
yield (for i <- 0 until size yield xss(y + i)(x + i))

def rects(size: Size, xss: Seq[Seq[Char]]): Iterator[Seq[Seq[Char]]] = for
    y <- (0 to xss.size - size.height).iterator
    x <- (0 to xss.head.size - size.width).iterator
yield xss.slice(y, y + size.height).map(_.slice(x, x + size.width))

def anyway(x: String)(y: String): Boolean =
    // we can skip some permutations by looking at the string we have in reverse
    x == y || x.reverse == y

def part1(xss: Seq[Seq[Char]]): Int =
    def countOccurances(xs: Seq[Char]) =
        xs.mkString.sliding(4).count(anyway("XMAS"))

    (xss ++ xss.transpose ++ rightDiagonal(4, xss) ++ leftDiagonal(4, xss))
        .map(countOccurances)
        .sum

def part2(xss: Seq[Seq[Char]]): Int =
    rects(Size(3, 3), xss).count {
        case Seq(
              Seq(a, _, b),
              Seq(_, c, _),
              Seq(d, _, e)
            ) =>
            List(s"$a$c$e", s"$b$c$d").forall(anyway("MAS"))
    }

@main def solutionDay4(): Unit = {
    Using(Source.fromResource("inputs/day04.txt")) { source =>
        val grid = source.getLines().map(_.toVector).toVector
        println(part1(grid))
        println(part2(grid))
    }
}
