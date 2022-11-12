package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputCheckTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:true", "15010:false", "1000:true", "15a0:false"], delimiter = ':')
    fun `로또 구입 가격 입력을 제대로 받았는지 검사 true`(input: String, expected: Boolean) {
        val result=checkInputLotteryPurchase(input.trim())
        assertThat(result).isEqualTo(expected)
    }

    private fun checkInputLotteryPurchase(input: String): Boolean {
        if (!checkInputOneInteger(input)) return false
        if (!isOneThousandUnit(input)) return false
        return true
    }

    private fun checkInputOneInteger(input: String): Boolean {
        input.forEach { if (!isNumber(it)) return false }
        return true
    }

    private fun isNumber(char: Char): Boolean = char.code in 48..57
    private fun isOneThousandUnit(input: String): Boolean = input.toInt() % 1000 == 0
}