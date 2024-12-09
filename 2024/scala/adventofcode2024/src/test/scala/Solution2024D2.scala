class Solution2024D2 extends munit.FunSuite {
  test("report safety solver") {
    val report1 = Vector(7, 6, 4, 2, 1)
    val report2 = Vector(1, 2, 7, 8, 9)
    val report3 = Vector(9, 7, 6, 2, 1)
    val report4 = Vector(1, 3, 2, 4, 5)
    val report5 = Vector(8, 6, 4, 4, 1)
    val report6 = Vector(1, 3, 6, 7, 9)
    val reports = List(report1, report2, report3, report4, report5, report6)

    assertEquals(isSafe(report1), true)
    assertEquals(isSafe(report2), false)
    assertEquals(isSafe(report3), false)
    assertEquals(isSafe(report4), false)
    assertEquals(isSafe(report5), false)
    assertEquals(isSafe(report6), true)
    assertEquals(numSafeReports(reports), 2)
  }

  test("dampened safety solver") {
    val report1 = Vector(7, 6, 4, 2, 1)
    val report2 = Vector(1, 2, 7, 8, 9)
    val report3 = Vector(9, 7, 6, 2, 1)
    val report4 = Vector(1, 3, 2, 4, 5)
    val report5 = Vector(8, 6, 4, 4, 1)
    val report6 = Vector(1, 3, 6, 7, 9)
    val reports = List(report1, report2, report3, report4, report5, report6)

    assertEquals(isAlmostSafe(report1), true)
    assertEquals(isAlmostSafe(report2), false)
    assertEquals(isAlmostSafe(report3), false)
    assertEquals(isAlmostSafe(report4), true)
    assertEquals(isAlmostSafe(report5), true)
    assertEquals(isAlmostSafe(report6), true)
    assertEquals(numSafeDampenedReports(reports), 4)
  }
}
