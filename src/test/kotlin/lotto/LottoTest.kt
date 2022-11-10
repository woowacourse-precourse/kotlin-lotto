package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
    // 아래에 추가 테스트 작성 가능

    @Test
    fun `구입 금액에 null이 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BuyAmount().exception("")
        }
    }

    @Test
    fun `구입 금액에 숫자가 아닌 다른 문자가 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BuyAmount().exception("abcd1234")
        }
    }

    @Test
    fun `구입 금액에 숫자가 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BuyAmount().exception(1500.toString())
        }
    }

    @Test
    fun `당첨 번호가 ,로 구분되어 6개가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().exception(listOf("1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `당첨 번호가 1~45가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().exception(listOf("1", "2", "3", "0", "5", "6"))
        }
    }
    @Test
    fun `당첨 번호가 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().exception(listOf("1", "2", "3", "a", "5", "6"))
        }
    }

    @Test
    fun `당첨 번호가 중복된 숫자가 있는 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber().exception(listOf("1", "2", "3", "3", "5", "6"))
        }
    }

    @Test
    fun `보너스 번호에 null이 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber().exception("")
        }
    }

    @Test
    fun `보너스 번호에 숫자가 아닌 다른 문자가 들어갈 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber().exception("ab")
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber().exception(100.toString())
        }
    }

}
