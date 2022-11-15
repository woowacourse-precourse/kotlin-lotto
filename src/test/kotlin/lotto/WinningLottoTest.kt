package lotto

import lotto.domain.lotto.Lotto
import lotto.domain.prize.LottoPrize
import lotto.domain.statistics.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `로또 일치하는 개수 카운터 테스트`() {
        val lottoNumbers = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
        val winningLotto = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val lotto = lottoNumbers.map { lotto -> Lotto(lotto) }
        val prize = WinningLotto(lotto, bonus).countWinningLotto(winningLotto)
        val result = prize[LottoPrize.FIFTH_PRIZE]
        val count = 1
        assertThat(result).isEqualTo(count)
    }
}