package lotto.util

import lotto.exceptions.DivisibleMoneyException

val br = System.`in`.bufferedReader()

fun readSpendMoney(): Int {
    return try {
        val spendMoney = br.readLine().toInt()
        if (spendMoney % 1000 != 0) {
            throw DivisibleMoneyException()
        }
        spendMoney
    } catch (e: Exception) {
        when (e) {
            is DivisibleMoneyException -> {
                printErrorMessage(ErrorType.CANNOT_DIVISIBLE_MONEY)
            }
            else -> {
                printErrorMessage(ErrorType.WRONG_TYPE_INPUT)
            }
        }
        throw IllegalArgumentException()
    }
}

fun bufferedReaderClose() {
    br.close()
}