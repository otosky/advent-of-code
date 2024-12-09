class Solution2024D1 extends munit.FunSuite {
  test("distance solver") {
    val l1 = List(3,4,2,1,3,3).map(_.toLong)
    val l2 = List(4,3,5,3,9,3).map(_.toLong)
    assertEquals(getDistance(l1, l2), 13L)
  }
  test("similarity solver") {
    val l1 = List(3,4,2,1,3,3).map(_.toLong)
    val l2 = List(4,3,5,3,9,3).map(_.toLong)
    assertEquals(getSimilarity(l1, l2), 31L)
  }
}
