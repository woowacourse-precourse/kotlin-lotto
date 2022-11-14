package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputCheckTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:true", "15010:false", "1000:true", "15a0:false"], delimiter = ':')
    fun `로또 구입 가격 입력을 제대로 받았는지 검사`(input: String, expected: Boolean) {
        val result = checkInputLotteryPurchase(input.trim())
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:true", "1,2,3,,4,5,6:false", "1,2,3:false", "1,2,4,4,5,6:false", "1,2,a,4,5,6:false"],
        delimiter = ':')
    fun `로또 당첨 번호 제대로 입력했는지 검사`(input: String, expected: Boolean) {
        val result = checkInputWinningLottery(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1:false", "45:true", "5:false", "4a1:false"],
        delimiter = ':')
    fun `로또 보너스 번호 제대로 입력했는지 검사`(input: String, expected: Boolean) {
        val winningLottery = listOf(1, 2, 3, 4, 5, 6)
        val result = checkInputBonusInteger(input, winningLottery)
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

    private fun checkInputWinningLottery(input: String): Boolean {
        val inputTrim = input.trim()
        if (!isConsistAllCommaAndNumber(inputTrim)) return false
        if (!isAlternatingCommaAndNumber(inputTrim)) return false
        val numbers = convertSeparateComma(inputTrim)
        numbers.forEach { if (!isLotteryRange(it)) return false }
        if (numbers.size != 6) return false
        if (numbers.toSet().size != 6) return false
        return true
    }

    private fun isConsistAllCommaAndNumber(input: String): Boolean {
        input.forEach {
            if (!(isNumber(it) || isComma(it) || it == ' ')) return false
        }
        return true
    }

    private fun isAlternatingCommaAndNumber(input: String): Boolean {
        var nowComma = false
        for (i in input.indices) {
            if (input[i] == ',') {
                if (nowComma) return false // 콤마가 나왓는데 또 연속으로 나온 경우
                nowComma = true
            } else if (isNumber(input[i])) {
                nowComma = false
            }
        }
        return !nowComma //마지막에 콤마가 오면 안됨
    }

    private fun convertSeparateComma(input: String): List<Int> {
        val numbers = input.split(",")
        return numbers.map { it.toInt() }
    }

    private fun isLotteryRange(num: Int) = num in 1..45

    private fun isComma(char: Char): Boolean = char.code == 44

    private fun checkInputBonusInteger(input: String, winningLottery: List<Int>): Boolean {
        val inputTrim = input.trim()
        if (!checkInputOneInteger(inputTrim)) return false
        if (!isLotteryRange(inputTrim.toInt())) return false
        if (winningLottery.contains(inputTrim.toInt())) return false
        return true
    }
}