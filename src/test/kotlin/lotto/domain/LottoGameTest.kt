package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest : NsTest() {
    @Test
    fun `입력 금액 예외 테스트 1`() {
        assertSimpleTest {
            runException("10-00")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `입력 금액 예외 테스트 2`() {
        assertSimpleTest {
            runException("one")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 생성기 오름차순 확인 테스트`() {
        Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                run("3000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]"
                )
            },
            listOf(41, 42, 43, 8, 21, 23),
            listOf(3, 5, 32, 38, 11, 16),
            listOf(7, 16, 11, 44, 35, 36)
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}