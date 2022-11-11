package lotto

import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class Winning(winningNumber: String) {
    private val luckyNumber = mutableListOf<Int>()
    private var bonusNumber = 0

    init {
        splitLuckyNumber(winningNumber)
        require(luckyNumber.size == 6) { "[ERROR] 번호를 6개 입력해 주세요" }
        validateLuckyNumberRange(luckyNumber)
        validateLuckyNumberDuplicate(luckyNumber)
    }

    private fun splitLuckyNumber(numbers: String) {
        numbers.split(",").forEach { number ->
            try {
                luckyNumber.add(number.toInt())
            } catch (exception: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")
            }
        }
    }

    fun getLuckyNumber() = luckyNumber

    fun getBonusNumber() = bonusNumber

    fun validateLuckyNumberRange(luckyNumber: List<Int>): Boolean {
        val count = luckyNumber.filter { number ->
            number in 1..45
        }.size
        return when (count) {
            6 -> true
            else -> throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.")
        }
    }

    fun validateLuckyNumberDuplicate(luckyNumber: List<Int>): Boolean {
        return when (luckyNumber.distinct().size) {
            6 -> true
            else -> throw IllegalArgumentException("[ERROR] 중복되지 않은 수를 입력해 주세요.")
        }
    }

    fun validateBonusNumberRange(bonusNumber: Int) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.")
        }
    }

    fun compareBonusWithLuckyNumber(bonusNumber: Int) {
        require(luckyNumber.size == 6) { "[ERROR] 로또 당첨 번호 6개가 필요합니다." }
        if (luckyNumber.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] 로또 당첨 번호와 중복되지 않는 숫자를 입력해 주세요.")
        }
    }

    fun inputBonusNumber(number: String) {
        bonusNumber = try {
            number.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요.")
        }
    }

    fun checkBonusNumberException() {
        validateBonusNumberRange(bonusNumber)
        compareBonusWithLuckyNumber(bonusNumber)
    }
}