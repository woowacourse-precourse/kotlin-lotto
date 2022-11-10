package lotto

import kotlin.IllegalArgumentException

class Winning {
    private val luckyNumber = mutableListOf<Int>()

    fun splitLuckyNumber(numbers: String) {
        numbers.split(",").forEach { number ->
            luckyNumber.add(number.toInt())
        }
        if (luckyNumber.size != 6)
            throw IllegalArgumentException("[ERROR] 로또 당첨 번호 6개를 입력해주세요.")
    }

    fun validateLuckyNumberRange(luckyNumber: List<Int>): Boolean {
        val count = luckyNumber.filter { number ->
            number in 1..45
        }.size
        return when(count){
            6 -> true
            else -> throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.")
        }
    }

    fun validateLuckyNumberDuplicate(luckyNumber: List<Int>): Boolean {
        return when(luckyNumber.distinct().size) {
            6 -> true
            else -> throw IllegalArgumentException("[ERROR] 중복되지 않은 수를 입력해주세요.")
        }
    }
}