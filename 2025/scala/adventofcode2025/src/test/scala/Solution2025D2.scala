import day02._

class Solution2025D2 extends munit.FunSuite {
    val lines = List("""11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                        |1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                        |824824821-824824827,2121212118-2121212124""".stripMargin)

    test("isInvalidId function") {
        assertEquals(isInvalidId("1212"), true)
        assertEquals(isInvalidId("99"), true)
        assertNotEquals(isInvalidId("123"), true)
    }

    test("part1 solver") {
        val ranges = parse(lines.iterator)
        assertEquals(sumInvalidIds(ranges), 1227775554L)
    }


}
