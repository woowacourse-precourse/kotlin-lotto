package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


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
    fun `1등 당첨 번호와 비교`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.matchLotto(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(WinningType.FIRST)
    }
    @Test
    fun `2등 당첨 번호와 비교`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        assertThat(lotto.matchLotto(listOf(1, 2, 3, 4, 5, 6), 8)).isEqualTo(WinningType.SECOND)
    }
    @Test
    fun `3등 당첨 번호와 비교`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lotto.matchLotto(listOf(1, 2, 3, 4, 5, 6), 8)).isEqualTo(WinningType.THIRD)
    }
    @Test
    fun `4등 당첨 번호와 비교`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        assertThat(lotto.matchLotto(listOf(1, 2, 3, 4, 5, 6), 8)).isEqualTo(WinningType.FOURTH)
    }
    @Test
    fun `5등 당첨 번호와 비교`() {
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        assertThat(lotto.matchLotto(listOf(1, 2, 3, 4, 5, 6), 8)).isEqualTo(WinningType.FIFTH)
    }
    @Test
    fun `당첨이 아예 아닌 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.matchLotto(listOf(7, 8, 9, 10, 11, 12), 13)).isEqualTo(WinningType.NOTHING)
    }
}
