package lotto.util

import lotto.exception.DivisibleMoneyException

val br = System.`in`.bufferedReader()

fun readPaidMoney(): Int {
    return try {
        val paidMoney = br.readLine().toInt()
        if (paidMoney % 1000 != 0) {
            throw DivisibleMoneyException()
        }
        paidMoney
    } catch (e: Exception) {
        mappingException(e)
        throw IllegalArgumentException()
    }
}

fun readWinLottoNumbers(): List<Int> {
    return try {
        val winLottoNumbers = br.readLine().split(',').map { it.toInt() }
        winLottoNumbers
    }catch (e: Exception){
        mappingException(e)
        throw IllegalArgumentException()
    }
}

private fun mappingException(e: Exception){
    when (e) {
        is DivisibleMoneyException -> {
            printErrorMessage(ErrorType.CANNOT_DIVISIBLE_MONEY)
        }
        is NumberFormatException -> {
            printErrorMessage(ErrorType.WRONG_TYPE_INPUT)
        }
        else -> {
            printErrorMessage(ErrorType.WRONG_VALUE)
        }
    }
}

fun bufferedReaderClose() {
    br.close()
}