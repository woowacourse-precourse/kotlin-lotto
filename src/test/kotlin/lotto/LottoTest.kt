package lotto

import lotto.domain.Lotto
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

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `1등 당첨인 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.confirmWinning(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(1)
    }

    @Test
    fun `2등 당첨인 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lotto.confirmWinning(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(2)
    }

    @Test
    fun `3등 당첨인 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        assertThat(lotto.confirmWinning(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(3)
    }

    @Test
    fun `4등 당첨인 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        assertThat(lotto.confirmWinning(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(4)
    }

    @Test
    fun `5등 당첨인 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        assertThat(lotto.confirmWinning(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(5)
    }

}
