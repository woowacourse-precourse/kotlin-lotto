package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `기능 테스트`() {
        assertThat(
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        )
    }

    @Test
    fun `로또 번호에 중복이 있을 때`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 6)
        }
    }

    @Test
    fun `로또 번호에 1부터 45의 이외의 숫자가 있을 때`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 50), 6)
        }
    }

    @Test
    fun `6개 이외의 개수가 들어 올 떄`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 6)
        }
    }

    @Test
    fun `보너스가 로또 번호와 중복일 떄`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 5)
        }
    }

    @Test
    fun `보너스가 1부터 45의 이외에 숫자일 때 `() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 50)
        }
    }

    @Test
    fun `getRank 기능 테스트`() {
        assertThat(
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(1, 2, 3, 4, 5, 6)) == 1 &&
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(1, 2, 3, 4, 5, 7)) == 2 &&
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(11, 12, 13, 14, 15, 16)) == 6
        )
    }

    @Test
    fun `getRank 입력 받은 숫자에 중복이 있을 때`() {
        assertThat(
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(1, 1, 1, 1, 1, 1)) == 6 &&
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(1, 2, 3, 4, 5, 5)) == 3
        )
    }

    @Test
    fun `getPrize 기능 테스트`() {
        assertThat(
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7).getRank(listOf(1, 2, 3, 4, 5, 6)) == LottoRank.FIRST.prize
        )
    }
}
