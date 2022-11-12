package lotto.util

import lotto.exceptions.DivisibleNumberException

val br = System.`in`.bufferedReader()

fun readSpendMoney(): Int {
    return try {
        val spendMoney = br.readLine().toInt()
        if (spendMoney % 1000 != 0) {
            throw DivisibleNumberException()
        }
        spendMoney
    } catch (e: Exception) {
        when(e){
            is DivisibleNumberException -> {
                printErrorMessage(ErrorType.CANNOT_DIVISIBLE_INPUT)
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