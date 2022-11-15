package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BonusNumberTest {
    @Test
    fun `로또 번호 범위를 벗어나는 보너스 번호면 예외가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            BonusNumber(46)
        }
    }

    @Test
    fun `isMatched 메서드에 당첨 번호를 인자로 주어 보너스 번호와 일치하는 게 있는지 판단`() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7)
        Assertions.assertThat(bonusNumber.isMatched(input)).isEqualTo(false)
    }
}