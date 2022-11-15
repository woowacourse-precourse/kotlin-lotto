package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ProfitCalculatorTest {
    private lateinit var calculator: ProfitCalculator
    private lateinit var ranks: List<Rank>

    @BeforeEach
    fun setUp() {
        calculator = ProfitCalculator()
        ranks = Rank.values().toList()
    }

    @ParameterizedTest
    @MethodSource("generateDataForCalculateTotalPrize")
    fun `총 당첨 금액 계산`(totalRanks: List<Int>, expected: Long) {
        val actual = calculator.calculateTotalPrize(ranks, totalRanks)
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateDataForCalculateTotalPrize(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(0, 0, 0, 0, 0), 0),
                Arguments.of(listOf(0, 0, 0, 0, 1), 5000),
                Arguments.of(listOf(1, 0, 1, 0, 1), 2001505000),
                Arguments.of(listOf(1, 1, 1, 1, 1), 2031555000),
            )
        }
    }
}