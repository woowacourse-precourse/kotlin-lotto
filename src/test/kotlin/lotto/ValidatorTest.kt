package lotto

import lotto.InputValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 100, 1500, 11500])
    fun `invalid money check`(money:Int){
        assertFalse(InputValidator.validateMoney(money))
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 5000, 100000])
    fun `valid money check`(money:Int){
        assertTrue(InputValidator.validateMoney(money))
    }

    @ParameterizedTest
    @MethodSource("generateInvalidWinningNumber")
    fun `invalid winning number check`(winningNumber:List<String>){
        assertFalse(InputValidator.validateWinningNumber(winningNumber))
    }

    @ParameterizedTest
    @MethodSource("generateValidWinningNumber")
    fun `valid winning number check`(winningNumber:List<String>){
        assertTrue(InputValidator.validateWinningNumber(winningNumber))
    }

    private fun generateInvalidWinningNumber(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf("1", "2", "3", "2", "4", "5")),
            Arguments.of(listOf("1", "2", "3", "4", "0", "45")),
            Arguments.of(listOf("1", "45", "46", "32", "34", "36")),
            Arguments.of(listOf("1", "1", "3", "4", "5", "22", "28")) ,
            Arguments.of(listOf("r", "1", "s", "4", "5", "24", "29"))
        )
    }

    private fun generateValidWinningNumber(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of(listOf("1", "2", "3", "4", "6", "9")),
            Arguments.of(listOf("32", "33", "1", "45", "43", "10")),
            Arguments.of(listOf("1", "45", "3", "4", "5", "12")) ,
            Arguments.of(listOf("2", "1", "3", "4", "5", "14"))
        )
    }

    @ParameterizedTest
    @MethodSource("generateInvalidBonusNumber")
    fun `invalid bonus number check`(bonusNumber: String, winningNumber:List<String>){
        assertFalse(InputValidator.validateBonusNumber(bonusNumber, winningNumber))
    }

    @ParameterizedTest
    @MethodSource("generateValidBonusNumber")
    fun `valid bonus number check`(bonusNumber: String, winningNumber:List<String>){
        assertTrue(InputValidator.validateBonusNumber(bonusNumber, winningNumber))
    }

    private fun generateInvalidBonusNumber(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("r", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("0", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("46", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("8", listOf("1", "2", "3", "4", "5", "8")),
        )
    }

    private fun generateValidBonusNumber(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("45", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("9", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("6", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("7", listOf("1", "2", "3", "4", "5", "8")),
            Arguments.of("23", listOf("1", "2", "3", "4", "5", "8")),
        )
    }
}
