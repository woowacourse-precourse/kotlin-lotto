package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoCheckerTest {
    private lateinit var lottoChecker: LottoChecker

    @BeforeEach
    fun setUp() {
        lottoChecker = LottoChecker()
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `당첨 번호와 일치하는 복권 번호의 개수를 알려준다`(numbers: List<Int>, winningNumbers: List<Int>, expected: Int) {
        assertThat(lottoChecker.countCorrectNumbers(numbers, winningNumbers)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 6, 32, 22, 10, 45), listOf(22, 8, 4, 9, 45, 1), 3),
                Arguments.of(listOf(1, 8, 12, 7, 5, 42), listOf(7, 11, 30, 40, 20, 43), 1),
                Arguments.of(listOf(8, 21, 23, 41, 42, 43), listOf(1, 2, 3, 4, 5, 6), 0)
            )
        }
    }
}