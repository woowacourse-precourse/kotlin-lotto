package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

internal class CalculatorTest {
    lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }
    @Test
    fun `수익금을 계산한다`() {
        val winners = listOf(1,0,0,1,0)
        val actual = calculator.calcProfits(winners)
        val expected = 30005000
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `수익률을 계산한다`() {
        val actual = calculator.calcEarningRate(5000, 8000)
        val expected = 62.5
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `소수점 둘째 자리에서 반올림한다`() {
        val actual = calculator.roundDigit(62.356, 2)
        val expected = 62.4
        assertThat(actual).isEqualTo(expected)
    }
}