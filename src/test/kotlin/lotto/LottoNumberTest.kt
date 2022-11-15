package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `구매 금액이 1000원 단위여야 한다`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(5300)
            lottoNumber.calculatePrice()
        }
    }

    @Test
    fun `보너스 번호가 범위 45를 넘으면 안된다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().checkBonus(46)
        }
    }

    @Test
    fun `보너스 번호가 범위 0이면 안된다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().checkBonus(0)
        }
    }


    @Test
    fun `구매 금액이 0원이면 안된다`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(0)
            lottoNumber.calculatePrice()
        }
    }

    @Test
    fun `당첨 번호가 숫자로 구성되어야 한다`() {
        assertThrows<IllegalArgumentException> {
            val winningNumber = WinningNumber()
            winningNumber.changeNumberList("1,2,3,4,5,j")
        }
    }
}