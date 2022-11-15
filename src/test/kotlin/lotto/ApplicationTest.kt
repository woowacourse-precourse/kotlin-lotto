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
        assertRandomUniqueNumbersInRangeTest(
            {
                run("15000", "8,10,13,25,18,32", "7")
                assertThat(output()).contains(
                    "15개를 구매했습니다.",
                    "[2, 3, 6, 10, 30, 41]",
                    "[7, 10, 13, 38, 39, 41]",
                    "[16, 21, 25, 35, 37, 39]",
                    "[13, 21, 30, 33, 35, 38]",
                    "[6, 10, 24, 28, 36, 45]",
                    "[1, 28, 34, 35, 38, 42]",
                    "[8, 10, 16, 17, 28, 43]",
                    "[18, 22, 29, 34, 42, 44]",
                    "[30, 33, 37, 38, 40, 44]",
                    "[10, 12, 22, 31, 32, 38]",
                    "[8, 13, 18, 32, 36, 45]",
                    "[7, 20, 21, 26, 34, 36]",
                    "[3, 11, 13, 19, 34, 42]",
                    "[3, 5, 6, 10, 43, 44]",
                    "[10, 13, 25, 32, 33, 45]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 2개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 666.7%입니다."
                )
            },
            listOf(2, 3, 6, 10, 30, 41),
            listOf(7, 10, 13, 38, 39, 41),
            listOf(16, 21, 25, 35, 37, 39),
            listOf(13, 21, 30, 33, 35, 38),
            listOf(6, 10, 24, 28, 36, 45),
            listOf(1, 28, 34, 35, 38, 42),
            listOf(8, 10, 16, 17, 28, 43),
            listOf(18, 22, 29, 34, 42, 44),
            listOf(30, 33, 37, 38, 40, 44),
            listOf(10, 12, 22, 31, 32, 38),
            listOf(8, 13, 18, 32, 36, 45),
            listOf(7, 20, 21, 26, 34, 36),
            listOf(3, 11, 13, 19, 34, 42),
            listOf(3, 5, 6, 10, 43, 44),
            listOf(10, 13, 25, 32, 33, 45)
        )
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
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(1,2,3,4,5,6)
        )
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
                    "총 수익률은 200,000,000.0%입니다."
                )
            },
            listOf(1,2,3,4,5,6)
        )
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
                    "총 수익률은 3,000,000.0%입니다."
                )
            },
            listOf(1,2,3,4,5,7)
        )
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
                    "총 수익률은 5,000.0%입니다."
                )
            },
            listOf(1,2,3,4,7,8)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("-30")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("1001")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("1000", "1,2,3,4,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("1000", "0,1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "0")
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
