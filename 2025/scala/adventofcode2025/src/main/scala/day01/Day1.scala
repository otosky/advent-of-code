package day01

import scala.io.Source
import scala.util.Using

def countZeros(elems: Seq[Int]): Long =
    elems
        .scanLeft(50)((sum, value) => (sum + value) % 100)
        .count(_ == 0)

def countZeroCrossings(elems: Seq[Int]): Long =
    elems
        .foldLeft((50, 0L)): (acc, elem) =>
            val (pos, count) = acc
            val newPos = ((pos + elem) % 100 + 100) % 100
            val fullCrosses = elem.abs / 100
            val remainder = elem % 100
            val posWithRemainder = pos + remainder

            val hasExtraCross = posWithRemainder match
                case 0             => 1
                case p if p < 0    => if pos > 0 || p <= -100 then 1 else 0
                case p if p >= 100 => 1
                case _             => 0

            (newPos, count + fullCrosses + hasExtraCross)
        ._2

@main def solution(): Unit =
    def parse(input: Iterator[String]): Seq[Int] =
        input
            .map:
                case s"L$n" => -n.toInt
                case s"R$n" => n.toInt
            .toSeq

    Using(Source.fromResource("inputs/day01.txt")): source =>
        val lines = parse(source.getLines())
        println(countZeros(lines)) // 1071
        println(countZeroCrossings(lines)) // 6700
