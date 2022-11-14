package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class CorrectCalculatorTest {

    private val correctCalculator = CorrectCalculator()
    val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `로또 번호 1개 맞을 경우`() {
        val result = correctCalculator.correctLottoNumber(winningLotto, Lotto(listOf(1, 7, 8, 9, 10, 11)))
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `로또 번호 3개 맞을 경우`() {
        val result = correctCalculator.correctLottoNumber(winningLotto, Lotto(listOf(9, 1, 10, 2, 3, 11)))
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `로또 번호 6개 맞을 경우`() {
        val result = correctCalculator.correctLottoNumber(winningLotto, Lotto(listOf(3, 6, 5, 1, 4, 2)))
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `보너스 번호 맞을 경우`() {
        val result = correctCalculator.correctBonusNumber(Lotto(listOf(1, 7, 8, 9, 10, 11)), 7)
        assertTrue(result)
    }

    @Test
    fun `보너스 번호 틀린 경우`() {
        val result = correctCalculator.correctBonusNumber(Lotto(listOf(1, 7, 8, 9, 10, 11)), 2)
        assertFalse(result)
    }
}