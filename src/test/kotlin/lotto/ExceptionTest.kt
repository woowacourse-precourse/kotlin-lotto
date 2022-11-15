package lotto

import lotto.domain.BonusNumberError
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import java.lang.IllegalArgumentException

class ExceptionTest {

    @Test
    fun `6개의 로또 번호가 보너스 번호와 중복된다면 예외가 발생한다`() {

        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 5
        assertThat(BonusNumberError(lottoNumber, bonusNumber))
    }

    @Test
    fun `보너스 번호가 1과 45 사이가 아니라면 예외가 발생한다`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 50
        assertThat(BonusNumberError(lottoNumber, bonusNumber))
    }

}