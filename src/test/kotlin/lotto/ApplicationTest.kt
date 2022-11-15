package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }
    @Test
    fun `기능 테스트1`() {
             assertRandomUniqueNumbersInRangeTest(
                 {
                     run("1000", "1,2,3,4,5,6", "7")
                     assertThat(output()).contains(
                         "1개를 구매했습니다.",
                         "[1, 2, 3, 7, 42, 43]",
                         "3개 일치 (5,000원) - 1개",
                         "4개 일치 (50,000원) - 0개",
                         "5개 일치 (1,500,000원) - 0개",
                         "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                         "6개 일치 (2,000,000,000원) - 0개",
                         "총 수익률은 500%입니다."
                     )
                 },
                 listOf(1, 2, 3, 7, 42, 43)
             )
         }
    @Test
    fun `기능 테스트2`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5000%입니다."
                    )
                },
                listOf(1, 2, 3, 4, 42, 43)
        )
    }
    @Test
    fun `기능 테스트3`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150000%입니다."
                    )
                },
                listOf(1, 2, 3, 4, 5, 43)
        )
    }
    @Test
    fun `기능 테스트4`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3000000%입니다."
                    )
                },
                listOf(1, 2, 3, 4, 5, 7)
        )
    }
    @Test
    fun `기능 테스트5`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000%입니다."
                    )
                },
                listOf(1, 2, 3, 4, 5, 6)
        )
    }
    @Test
    fun `당첨 안됬을 경우`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "7")
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 9, 10, 11, 12, 13]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0%입니다."
                    )
                },
                listOf(8, 9, 10, 11, 12, 13)
        )
    }
    @Test
    fun `보너스 범위 초가`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "47")
                    assertThat(output()).contains(ERROR_MESSAGE)
                },
                listOf(8, 9, 10, 11, 12, 13)

        )
    }
    @Test
    fun `보너스 중복`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("1000", "1,2,3,4,5,6", "6")
                    assertThat(output()).contains(ERROR_MESSAGE)
                },
                listOf(8, 9, 10, 11, 12, 13)

        )
    }

    @Test
    fun `구입금액 안쳤을때`() {
        assertRandomUniqueNumbersInRangeTest(
                {
                    run("", "1,2,3,4,5,6", "ㄷ")
                    assertThat(output()).contains(ERROR_MESSAGE)
                },
                listOf(8, 9, 10, 11, 12, 13)

        )
    }
    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `예외 테스트2`() {
        assertSimpleTest {
            runException("100q")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `예외 테스트3`() {
        assertSimpleTest {
            runException("1001")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `예외 테스트4`() {
        assertSimpleTest {
            runException(" ")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `예외 테스트5`() {
        assertSimpleTest {
            runException("100 00")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
