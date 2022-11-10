package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

class WinnigResultTest {

    val answer = Lotto(listOf(1, 5, 14, 22, 33, 41))
    val bonus = 3
    val winnigResult = WinningResult()

    fun `당첨 결과가 5등인지 확인`() {
        val user = Lotto(listOf(1, 7, 14, 25, 33, 42))
        val result = LottoGrade.FIFTH

        assertThat(winningResult.matchLotto(answer, user, bonus)).isEqualTo(result)
    }

    fun `당첨 결과가 4등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 25, 33, 42))
        val result = LottoGrade.FOURTH

        assertThat(winningResult.matchLotto(answer, user, bonus)).isEqualTo(result)
    }

    fun `당첨 결과가 3등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 25, 33, 41))
        val result = LottoGrade.THIRD

        assertThat(winningResult.matchLotto(answer, user, bonus)).isEqualTo(result)
    }

    fun `당첨 결과가 2등인지 확인`() {
        val user = Lotto(listOf(1, 3, 5, 14, 33, 42))
        val result = LottoGrade.SECOND

        assertThat(winningResult.matchLotto(answer, user, bonus)).isEqualTo(result)
    }

    fun `당첨 결과가 1등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 25, 33, 42))
        val result = LottoGrade.FIRST

        assertThat(winningResult.matchLotto(answer, user, bonus)).isEqualTo(result)
    }
}