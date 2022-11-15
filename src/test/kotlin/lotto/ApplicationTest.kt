package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest

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

//    @ParameterizedTest
//    @ValueSource(strings = {"1000j", "1234"})
//    fun `예외 테스트`(input: String) {
//        assertThrows<IllegalArgumentException> {
//            getUserMoney(input) // 문자 포함
//            getUserMoney("1234")  // 1000으로 나눠 떨어지지 않는 경우
//
//            getWinningNumbers("1,2,3,j") // 문자 포함
//            getWinningNumbers("1,2,0,45") // 1~45 범위 벗어난 경우
//            getWinningNumbers("1,2,2,3,4,5") // 중복된 숫자
//            getWinningNumbers("1,2,3,4,5,6,7") // 6개가 아닌 경우
//            getWinningNumbers("1,2,3,4")
//
//            getBonusNumber("45j") // 문자 포함
//            getBonusNumber("100") // 1~45 범위 벗어난 경우
//        }
//    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

    override fun runMain() {
        main()
    }
}
