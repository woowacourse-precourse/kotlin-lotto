package lotto.util

import java.lang.IllegalArgumentException

object Validator {
    fun checkMoney(money: String){
        if (money.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        }
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        }
    }

    fun checkWinningNumber(number: String): List<Int> {
        val winningNumber = mutableListOf<Int>()
        number.split(',').forEach {
            it.toIntOrNull()?.let { winningNumber.add(it) }
        }
        if (winningNumber.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 콤마로 구분해 입력해주세요.")
        }
        for (number in winningNumber) {
            if (number !in 1..45) {
                throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.")
            }
        }
        return winningNumber.sorted().toList()
    }

/*    fun checkPurchaseAmount(input: String): String {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_INT_OR_NULL)
        }
        if (input.toInt() % LOTTO_PRICE != 0) {
            throw IllegalArgumentException(ERROR_THOUSAND)
        }
        return input
    }

    fun getPurchaseNumber(input: String): Int {
        var money = input.toInt()
        return money / LOTTO_PRICE
    }

    fun checkWinningNumber(input: String): List<Int> {
        var lottoNumber = mutableListOf<Int>()
        input.split(",").forEach() { it ->
            it.toIntOrNull()?.let { lottoNumber.add(it) }
        }
        lottoNumber.sort()
        var winningNumber = lottoNumber.distinct().filter { it in 1..45 }
        if (winningNumber.size != LOTTO_SIZE) {
            throw IllegalArgumentException(ERROR_SIX_LENGTH)
        }
        return winningNumber.sorted()
    }

    fun checkBonusNumber(input: String): String {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMERIC)
        } else if (input.toInt() !in 1..45) {
            throw IllegalArgumentException(ERROR_1_45_RANGE)
        } else if (input.toInt() in winningNumber){
            throw IllegalArgumentException(ERROR_ALREADY_IN)
        }
        return input
    }*/
}