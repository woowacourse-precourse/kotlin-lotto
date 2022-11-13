package lotto

import exception.LottoBonus
import exception.LottoPurchase
import exception.LottoWinning
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `구입 금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase("1000j")
        }
    }

    @Test
    fun `구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase("8500")
        }
    }

    @Test
    fun `당첨 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning("1,2,3,4,46,47")
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 존재하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning("1,2,3,4,3,10")
        }
    }

    @Test
    fun `당첨 번호 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWinning("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoBonus(50)
        }
    }
}
