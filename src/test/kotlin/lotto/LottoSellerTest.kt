package lotto

import lotto.ui.LottoSeller
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoSellerTest {

    @Test
    fun `로또 보너스 번호가 1보다 작을때 예외처리 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoSeller().inputBonusNumberException(0)
        }
    }

    @Test
    fun `로또 보너스 번호가 45보다 클때 예외처리 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoSeller().inputBonusNumberException(46)
        }
    }

    @Test
    fun `로또 보너스 번호가 숫자가 아닐때 예외처리 한다`() {
        val testString = "asd"
        assertThrows<IllegalArgumentException> {
            LottoSeller().inputBonusNumberException(testString.toInt())
        }
    }

    @Test
    fun `발행할 로또 갯수 계산 테스트`() {
        val testNumber = LottoSeller().lottoCount(8000)
        Assertions.assertEquals(8, testNumber)
    }
}