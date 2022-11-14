package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    val calc = Calculator()
    val lotto = Lotto(listOf(1,2,3,4,5,6))
    @Test
    fun compareLottoNumTest() {
        assertThat(calc.checLotto(listOf(1,2,3,4,5,6), lotto, 7, )).isEqualTo(Answer.SIX)
        assertThat(calc.checLotto(listOf(1,2,3,4,5,7), lotto,7, )).isEqualTo(Answer.BONUS)
        assertThat(calc.checLotto(listOf(1,2,3,4,15,16), lotto,7, )).isEqualTo(Answer.FOUR)
        assertThat(calc.checLotto(listOf(1,2,3,14,15,16), lotto, 7, )).isEqualTo(Answer.THREE)
    }

    @Test
    fun calculateYieldTest() {
        assertThat(calc.calculateYield(8, listOf(1,0,0,0,0))).isEqualTo(62.5)
        assertThat(calc.calculateYield(8, listOf(0,1,0,0,0))).isEqualTo(625.0)
    }
}