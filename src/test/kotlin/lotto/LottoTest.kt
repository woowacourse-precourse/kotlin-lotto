package lotto

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class LottoTest {
    var judgment = Judgment()

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
    fun `로또 구매 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            judgment.checkPurchaseAmount("5001")
        }
    }

    @Test
    fun `로또 구매 금액이 숫자 형태가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            judgment.checkPurchaseAmount("   5000")
        }
    }

    @Test
    fun `당첨 번호가 6자리가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            var lottoNumber  = mutableListOf<Int>(1,2,23,23,50,18)
            judgment.checkWinningNumber(lottoNumber)
        }
    }
}
