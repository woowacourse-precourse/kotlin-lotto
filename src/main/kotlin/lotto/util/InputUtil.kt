package lotto.util

import lotto.constant.LOTTO_NUM_COUNT
import lotto.exception.DivisibleMoneyException
import lotto.exception.InputCountException

val br = System.`in`.bufferedReader()

fun readPaidMoney(): Int {
    return try {
        val paidMoney = br.readLine().toInt()
        if (paidMoney % 1000 != 0) {
            throw DivisibleMoneyException()
        }
        paidMoney
    } catch (e: Exception) {
        showError(e)
        throw IllegalArgumentException()
    }
}

fun readWinLottoNumbers(): List<Int> {
    return try {
        val winLottoNumbers = br.readLine().split(',').map { it.toInt() }.also { winLottoNumbers ->
            if (winLottoNumbers.size != LOTTO_NUM_COUNT) throw InputCountException()
        }
        winLottoNumbers
    } catch (e: Exception) {
        showError(e)
        throw IllegalArgumentException()
    }
}


fun bufferedReaderClose() {
    br.close()
}