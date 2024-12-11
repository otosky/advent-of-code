import adventofcode2024.day4._

class Solution2024D4 extends munit.FunSuite {
    test("find xmas solver") {
        val input =
            """MMMSXXMASM
              |MSAMXMSMSA
              |AMXSXMAAMM
              |MSAMASMSMX
              |XMASAMXAMM
              |XXAMMXXAMA
              |SMSMSASXSS
              |SAXAMASAAA
              |MAMMMXMMMM
              |MXMXAXMASX""".stripMargin
        val grid = input.linesIterator.map(_.toVector).toVector    
        assertEquals(part1(grid), 18)
    }
}
