package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest : NsTest() {
    @Test
    fun `입력 금액 예외 테스트 1` () {
        assertSimpleTest {
            runException("10-00")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `입력 금액 예외 테스트 2` () {
        assertSimpleTest {
            runException("one")
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