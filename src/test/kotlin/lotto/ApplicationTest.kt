package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `1000원 단위가 아닌 숫자를 구매 금액으로 입력받았을 경우`() {
        assertThrows<IllegalArgumentException> { runException("1100") }
    }

    @Test
    fun `범위에서 벗어나거나 숫자가 아닌 값을 입력한 경우`() {
        assertThrows<IllegalArgumentException> {
            lottoWinNum = arrayListOf(1,2,3,4,5,1100).toIntArray()
            winNumInputCheck()
            runException("hello2023")
        }
        assertThrows<IllegalArgumentException> {
            var lottoWinNumTest = arrayListOf(1,2,3,4,5,"hello2023")
            for (num in lottoWinNumTest) {
                if (!checkDigit(num.toString())) throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호가 중복되는 경우`() {
        assertThrows<IllegalArgumentException> {
            lottoWinNum = arrayListOf(1,2,3,4,5,6).toIntArray()
            bonusNum = 3
            bonusNumInputCheck()
        }
    }
}
