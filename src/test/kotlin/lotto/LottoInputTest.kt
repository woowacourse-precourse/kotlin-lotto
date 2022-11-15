package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoInputTest {

    @Test
    fun `로또 구입 금액이 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getInputLottoPriceNotNumericException("Lotto")
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getInputLottoPriceUnitException(4600)
        }
    }

    @Test
    fun `로또 당첨 번호 중 숫자가 아닌 다른 문자가 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getLottoNumNumericException("1,2,5,a,6,7")
        }
    }

    @Test
    fun `로또 당첨 번호가 쉼표로 구분되지 않는다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getLottoNumCommaException("1,2,346,7")
        }
    }

    @Test
    fun `로또 보너스 번호가 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getBonusNumericException("@")
        }
    }

    @Test
    fun `로또 보너스 번호가 1개 이상 이라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getBonusLengthException("111")
        }
    }

    @Test
    fun `로또 보너스 번호가 당첨 번호와 중복이라면 예외가 발생한다`() {

        val bonus = 3
        val winNumbers = listOf(1,2,3,4,5,6)

        assertThrows<IllegalArgumentException> {
            LottoExecptions().getBonusDuplicateException(bonus, winNumbers)
        }
    }

    @Test
    fun `로또 보너스 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoExecptions().getBonusRangeException(100)
        }
    }

}