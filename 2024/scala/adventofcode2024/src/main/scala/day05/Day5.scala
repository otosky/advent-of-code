package day05

import scala.annotation.tailrec
import scala.io.Source
import scala.util.Using

type Rule = (Int, Int)
type Rules = Seq[Rule]
type Page = Seq[Int]
type Pages = Seq[Page]

def parseRule(rule: String) = rule match
    case s"$a|$b" => (a.toInt, b.toInt)
def parseRules(rules: Iterator[String]) = rules.map(parseRule).toSeq
def parsePage(page: String) = page.split(",").map(_.toInt).toList
def parsePages(pages: Iterator[String]) = pages.map(parsePage).toSeq

def parse(s: String): (Rules, Pages) =
    val Array(rulesString, pagesString) = s.split("\n\n")
    (
      parseRules(rulesString.linesIterator),
      parsePages(pagesString.linesIterator)
    )

def validatePage(ruleMap: Map[Int, Seq[Int]])(page: Page): Boolean =
    @tailrec
    def loop(page: Page, visited: Set[Int] = Set.empty): Boolean = page match
        case Nil => true
        case num :: rest =>
            !ruleMap.getOrElse(num, List.empty).exists(visited.contains)
            && loop(rest, visited + num)

    loop(page)

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
