package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


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
    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun `compareWinningNumber() 테스트`(winningNumber: List<String>, bonus: String, result: Int) {
        assertThat(result).isEqualTo(
            lotto.compareWinningNumber(winningNumber, bonus)
        )
    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> {
            return Stream.of(
                arguments(listOf("1", "2", "3", "4", "5", "6"), "7", 4),
                arguments(listOf("1", "2", "3", "4", "5", "8"), "6", 3),
                arguments(listOf("1", "2", "3", "4", "5", "12"), "10", 2),
                arguments(listOf("1", "2", "3", "4", "34", "36"), "45", 1),
                arguments(listOf("1", "2", "3", "31", "24", "34"), "7", 0),
                arguments(listOf("1", "2", "31", "41", "15", "16"), "7", -1)
            )
        }
    }
}