package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `사용자 구매 입력 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            runException("1000j")
        }
    }

    @Test
    fun `사용자 구매 입력 예외 테스트 금액 낮음`() {
        assertThrows<IllegalArgumentException> {
            runException("900")
        }
    }

    @Test
    fun `사용자 구매 입력 예외 테스트 mod`() {
        assertThrows<IllegalArgumentException> {
            runException("1200")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 문자`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6j")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 숫자 범위`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,46")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 중복`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,5")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 개수`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 공백`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6 ")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 콤마`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6,")
        }
    }

    @Test
    fun `당첨 번호 입력 테스트 예외 구분자`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1.2.3.4.5.6.")
        }
    }

    @Test
    fun `보너스 번호 입력 테스트 예외 문자`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6", "j")
        }
    }

    @Test
    fun `보너스 번호 입력 테스트 예외 숫자 범위`() {
        assertThrows<IllegalArgumentException> {
            runException("1000", "1,2,3,4,5,6", "46")
        }
    }
//
//    @Test
//    fun `기능 테스트`() {
//        assertRandomUniqueNumbersInRangeTest(
//            {
//                run("8000", "1,2,3,4,5,6", "7")
//                assertThat(output()).contains(
//                    "8개를 구매했습니다.",
//                    "[8, 21, 23, 41, 42, 43]",
//                    "[3, 5, 11, 16, 32, 38]",
//                    "[7, 11, 16, 35, 36, 44]",
//                    "[1, 8, 11, 31, 41, 42]",
//                    "[13, 14, 16, 38, 42, 45]",
//                    "[7, 11, 30, 40, 42, 43]",
//                    "[2, 13, 22, 32, 38, 45]",
//                    "[1, 3, 5, 14, 22, 45]",
//                    "3개 일치 (5,000원) - 1개",
//                    "4개 일치 (50,000원) - 0개",
//                    "5개 일치 (1,500,000원) - 0개",
//                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
//                    "6개 일치 (2,000,000,000원) - 0개",
//                    "총 수익률은 62.5%입니다."
//                )
//            },
//            listOf(8, 21, 23, 41, 42, 43),
//            listOf(3, 5, 11, 16, 32, 38),
//            listOf(7, 11, 16, 35, 36, 44),
//            listOf(1, 8, 11, 31, 41, 42),
//            listOf(13, 14, 16, 38, 42, 45),
//            listOf(7, 11, 30, 40, 42, 43),
//            listOf(2, 13, 22, 32, 38, 45),
//            listOf(1, 3, 5, 14, 22, 45)
//        )
//    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
