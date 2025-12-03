import day01._

class Solution2025D1 extends munit.FunSuite {
    val elems = List(-68, -30, 48, -5, 60, -55, -1, -99, 14, -82)

    test("zeros solver") {
        assertEquals(countZeros(elems), 3L)
    }

    test("crossing solver") {
        assertEquals(countZeroCrossings(elems), 6L)
    }
}
