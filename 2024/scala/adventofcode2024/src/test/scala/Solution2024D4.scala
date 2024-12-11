import adventofcode2024.day4._

class Solution2024D4 extends munit.FunSuite {
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
        
    test("find xmas solver") {
        val grid = input.linesIterator.map(_.toVector).toVector    
        assertEquals(part1(grid), 18)
    }
    
    test("x-mas solver") {
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
        assertEquals(part2(grid), 9)
    }
}
