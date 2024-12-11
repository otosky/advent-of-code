import day03._

class Solution2024D3 extends munit.FunSuite {
    test("valid mult solver") {
        val s = ")mul(1,100)where()how()mul(2,10);m"

        assertEquals(part1(s), 100 + 20)
    }

    test("enabled mult solver") {
        val s =
            "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        assertEquals(part2(s), 2 * 4 + 8 * 5)
    }
}
