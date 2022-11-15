package lotto.domainTest

import lotto.domain.Compare
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CompareTest {
    @Test
    fun `로또와 당첨번호 비교`() {
        val compare = Compare()
        val win = listOf(1, 2, 3, 4, 5, 12)
        val lotto = listOf(1, 2, 3, 4, 6, 12)
        val result = compare.checkWinningNumbers(win, lotto)
        Assertions.assertThat(result).isEqualTo(5)
    }

    @Test
    fun `로또와 보너스 번호 비교`() {
        val compare = Compare()
        val bonus = 6
        val lotto = listOf(1, 2, 3, 4, 6, 12)
        val result = compare.checkBonusNumber(bonus, lotto)
        Assertions.assertThat(result).isEqualTo(true)
    }
}