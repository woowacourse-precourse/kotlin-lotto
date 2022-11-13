package lotto

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResultExtractorTest {
    @ParameterizedTest
    @MethodSource("generateFifthPlace")
    fun `extractor check a fifth place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.FIFTH_PLACE to 1))
    }

    private fun generateFifthPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf(Lotto(listOf(8, 21, 23, 41, 42, 43))), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(listOf(Lotto(listOf(4, 5, 21, 40, 42, 43))), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(listOf(Lotto(listOf(1, 2, 3, 40, 42, 43))), listOf(1, 2, 3, 4, 5, 6), 7)
        )
    }

    @ParameterizedTest
    @MethodSource("generateTwoFifthPlace")
    fun `extractor check two fifth place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.FIFTH_PLACE to 2))
    }

    private fun generateTwoFifthPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    Lotto(listOf(8, 21, 23, 41, 42, 43)),
                    Lotto(listOf(3, 4, 5, 6, 9, 11))
                ), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(4, 5, 21, 40, 42, 43)),
                    Lotto(listOf(1, 4, 5, 6, 41, 11))
                ), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 40, 42, 43)),
                    Lotto(listOf(4, 5, 6, 40, 42, 43))
                ), listOf(1, 2, 3, 4, 5, 6), 7)
        )
    }

    @ParameterizedTest
    @MethodSource("generateTwoFourthPlace")
    fun `extractor check two fourth place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.FOURTH_PLACE to 2))
    }

    private fun generateTwoFourthPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    Lotto(listOf(8, 21, 41, 3, 42, 43)),
                    Lotto(listOf(3, 4, 5, 8, 9, 11))
                ), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(4, 5, 21, 8, 42, 43)),
                    Lotto(listOf(3, 4, 5, 6, 41, 11))
                ), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 42, 43)),
                    Lotto(listOf(4, 5, 6, 1, 42, 43))
                ), listOf(1, 2, 3, 4, 5, 6), 7)
        )
    }

    @ParameterizedTest
    @MethodSource("generateTwoThirdPlace")
    fun `extractor check two third place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.THIRD_PLACE to 2))
    }

    private fun generateTwoThirdPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    Lotto(listOf(8, 21, 41, 3, 5, 43)),
                    Lotto(listOf(3, 4, 5, 8, 41, 11))
                ), listOf(21, 41, 3, 4, 5, 8), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 43)),
                    Lotto(listOf(4, 5, 6, 1, 3, 43))
                ), listOf(1, 2, 3, 4, 5, 6), 7)
        )
    }

    @ParameterizedTest
    @MethodSource("generateTwoSecondPlace")
    fun `extractor check two second place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.SECOND_PLACE to 2))
    }

    private fun generateTwoSecondPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto(listOf(7, 5, 6, 1, 3, 2))
                ), listOf(1, 2, 3, 4, 5, 6), 7),
            Arguments.of(
                listOf(
                    Lotto(listOf(10, 11, 12, 13, 14, 16)),
                    Lotto(listOf(11, 12, 13, 14, 15, 16))
                ), listOf(10, 11, 12, 13, 14, 15), 16)
        )
    }

    @ParameterizedTest
    @MethodSource("generateTwoFirstPlace")
    fun `extractor check two first place`(purchasedLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) {
        assertThat(ResultExtractor.extractResult(purchasedLotto,
            winningNumber,
            bonusNumber)).isEqualTo(mapOf(LottoPrice.FIRST_PLACE to 2))
    }

    private fun generateTwoFirstPlace(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto(listOf(7, 5, 4, 1, 3, 2))
                ), listOf(1, 2, 3, 4, 5, 7), 8),
            Arguments.of(
                listOf(
                    Lotto(listOf(10, 11, 12, 13, 14, 16)),
                    Lotto(listOf(11, 12, 13, 14, 10, 16))
                ), listOf(10, 11, 12, 13, 14, 16), 17)
        )
    }
}