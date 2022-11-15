package lotto

import lotto.Model.Lotto
import lotto.Model.Money
import lotto.Model.Rank
import org.assertj.core.api.Assertions.assertThat
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
    fun `로또 번호가 특정 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 11, 2, 22, 23, 46))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만이라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 구입 금액 예외`() {
        assertThrows<IllegalArgumentException> {
            Money(2200)
        }
        assertThrows<IllegalArgumentException> {
            Money(0)
        }
    }

    class LottoResultTest {
        private val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))
        private val bonusNumber = 7

        @Test
        fun `로또 2등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
            assertThat(lotto.calculateWinningResult(winningNumber, bonusNumber)).isEqualTo(Rank.Second)
        }

        @Test
        fun `로또 3등`() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
            assertThat(lotto.calculateWinningResult(winningNumber, bonusNumber)).isEqualTo(Rank.Third)
        }

        @Test
        fun `로또 5등`() {
            val lotto = Lotto(listOf(1, 2, 3, 11, 22, 33))
            assertThat(lotto.calculateWinningResult(winningNumber, bonusNumber)).isEqualTo(Rank.Fifth)
        }
    }
}
