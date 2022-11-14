package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoWinTest :NsTest(){
    @Test
    fun `당첨 번호의 개수가 6개가 아니다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputNumbers("1,2,3,4,5,6,7")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `당첨 번호에 숫자가 아닌 수가 들어온다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputNumbers("1,2,3,4,5,a")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `당첨 번호에 범위 밖의 값이 있다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputNumbers("1,2,3,4,5,47")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `당첨 번호가 중복된다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputNumbers("1,2,3,4,5,5")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `보너스 번호가 숫자가 아니다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputBonus("a")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `보너스 번호가 범위 밖의 값이다`() {
        assertThrows<IllegalArgumentException> {
            LottoWin.inputBonus("0")
        }
        Assertions.assertThat(output()).contains(ERROR_MESSAGE)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
