package lotto

import lotto.domain.BonusNumberError
import lotto.domain.Lotto
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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `1 ~ 45 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(8, 12, 17, 26, 37, 56))
        }
    }

    @Test
    fun `6개의 로또 번호가 보너스 번호와 중복된다면 예외가 발생한다`() {

        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 5
        assertThrows<IllegalArgumentException> {
            BonusNumberError(lottoNumber, bonusNumber)
        }
    }

}
