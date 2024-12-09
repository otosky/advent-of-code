class Solution2024D2 extends munit.FunSuite {
  test("report safety solver") {
    val report1 = List(7, 6,4,2,1)
    val report2 = List(1,2,7,8,9)
    val report3 = List(9,7,6,2,1)
    val report4 = List(1,3,2,4,5)
    val report5 = List(8,6,4,4,1)
    val report6 = List(1,3,6,7,9)
    val reports = List(report1, report2, report3, report4, report5, report6)

    assertEquals(isReportSafe(report1), true)
    assertEquals(isReportSafe(report2), false)
    assertEquals(isReportSafe(report3), false)
    assertEquals(isReportSafe(report4), false)
    assertEquals(isReportSafe(report5), false)
    assertEquals(isReportSafe(report6), true)
    assertEquals(numSafeReports(reports), 2)
  }

  test("dampened safety solver") {
    val report1 = List(7, 6,4,2,1)
    val report2 = List(1,2,7,8,9)
    val report3 = List(9,7,6,2,1)
    val report4 = List(1,3,2,4,5)
    val report5 = List(8,6,4,4,1)
    val report6 = List(1,3,6,7,9)
    val reports = List(report1, report2, report3, report4, report5, report6)

    assertEquals(isDampenedSafe(report1), true)
    assertEquals(isDampenedSafe(report2), false)
    assertEquals(isDampenedSafe(report3), false)
    assertEquals(isDampenedSafe(report4), true)
    assertEquals(isDampenedSafe(report5), true)
    assertEquals(isDampenedSafe(report6), true)
    assertEquals(numSafeDampenedReports(reports), 4)
  }
}
