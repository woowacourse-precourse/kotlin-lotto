package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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
    fun `로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호를 문자열로 반환해준다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val expected = "[1, 2, 3, 4, 5, 6]"
        assertThat(lotto.getTicket()).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateDataForGetRank")
    fun `로또의 등수를 계산한다`(winningNumbers: List<Int>, bonusNumber: Int, expected: Rank) {
        val lotto = Lotto(listOf(1, 6, 32, 22, 10, 45))
        assertThat(lotto.getRank(winningNumbers, bonusNumber)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateDataForGetRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 6, 32, 22, 10, 45), 22, Rank.FIRST),
                Arguments.of(listOf(1, 6, 12, 22, 10, 45), 22, Rank.SECOND),
                Arguments.of(listOf(1, 6, 12, 22, 10, 45), 7, Rank.THIRD),
                Arguments.of(listOf(1, 6, 12, 5, 10, 45), 22, Rank.FOURTH),
                Arguments.of(listOf(1, 6, 12, 22, 9, 44), 22, Rank.FIFTH)
            )
        }
    }
}
