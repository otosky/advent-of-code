package day05

import scala.annotation.tailrec
import scala.io.Source
import scala.util.Using

type Rule = (Int, Int)
type Rules = Seq[Rule]
type Page = Seq[Int]
type Pages = Seq[Page]

def validatePage(ruleMap: Map[Int, Seq[Int]])(page: Page): Boolean =
    @tailrec
    def loop(page: Page, visited: Set[Int] = Set.empty): Boolean = page match
        case Nil => true
        case num :: rest =>
            !ruleMap.getOrElse(num, List.empty).exists(visited.contains)
            && loop(rest, visited + num)

    loop(page)

def parse(s: String): (Rules, Pages) =
    val Array(rulesString, updatesString) = s.split("\n\n")
    val rules = rulesString.linesIterator.map { case s"$fst|$snd" =>
        (fst.toInt, snd.toInt)
    }.toList
    val pages =
        updatesString.linesIterator.map(_.split(",").map(_.toInt).toList).toList
    (rules, pages)

def part1(rules: Rules, pages: Pages): Int = {
    val ruleMap = rules.groupMap(_._1)(_._2)
    pages.filter(validatePage(ruleMap)).map(p => p(p.size / 2)).sum
}
def part2(): Int = ???

@main def solutionDay5(): Unit = {
    Using(Source.fromResource("inputs/day5.txt")) { source =>
        val (rules, pages) = parse(source.mkString)
        println(part1(rules, pages))
    }
}
