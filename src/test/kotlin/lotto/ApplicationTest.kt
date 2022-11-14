package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `기능 테스트_1`() {
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
    fun `기능 테스트_2`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("6000", "1,2,3,4,5,6", "10")
                assertThat(output()).contains(
                    "6개를 구매했습니다.",
                    "[2, 3, 9, 10, 11, 12]",
                    "[2, 3, 5, 10, 32, 43]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[2, 3, 4, 5, 6, 10]",
                    "[1, 2, 3, 4, 5, 10]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 1000083.3%입니다."
                )
            },
            listOf(2, 3, 9, 10, 11, 12),
            listOf(2, 3, 5, 32, 10, 43),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(2, 3, 4, 5, 6, 10),
            listOf(1, 2, 3, 4, 5, 10)
        )
    }

    @Test
    fun `기능 테스트_3`() {
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
                    "총 수익률은 200000000.0%입니다."
                )
            },
            listOf(6, 4, 5, 3, 2, 1)
        )
    }

    @Test
    fun `기능 테스트_수익률 제로`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("5000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "5개를 구매했습니다.",
                    "[1, 2, 7, 8, 10, 12]",
                    "[7, 8, 9, 10, 11, 12]",
                    "[12, 15, 17, 19, 20, 21]",
                    "[30, 32, 40, 41, 42, 43]",
                    "[1, 2, 7, 10, 11, 12]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다."
                )
            },
            listOf(12, 7, 8, 2, 10, 1),
            listOf(7, 8, 9, 11, 10, 12),
            listOf(17, 20, 12, 19, 15, 21),
            listOf(30, 32, 40, 41, 42, 43),
            listOf(1, 2, 7, 10, 11, 12)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
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
