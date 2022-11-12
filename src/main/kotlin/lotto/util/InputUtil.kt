package lotto.util

import lotto.exceptions.DivisibleMoneyException

val br = System.`in`.bufferedReader()

fun readPaidMoney(): Int {
    return try {
        val paidMoney = br.readLine().toInt()
        if (paidMoney % 1000 != 0) {
            throw DivisibleMoneyException()
        }
        paidMoney
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