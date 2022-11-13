package lotto.util

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.constant.LOTTO_NUM_COUNT
import lotto.exception.DivisibleMoneyException
import lotto.exception.DuplicateInputException
import lotto.exception.InputCountException

fun readPaidMoney(): Int {
    return try {
        val paidMoney = readLine().toInt()
        if (paidMoney % 1000 != 0) {
            throw DivisibleMoneyException()
        }
        paidMoney
    } catch (e: Exception) {
        showError(e)
        throw NoSuchElementException()
    }
}

fun readWinLottoNumbers(): List<Int> {
    return try {
        val winLottoNumbers = readLine().split(',').map { it.toInt() }.also { winLottoNumbers ->
            if (winLottoNumbers.size != LOTTO_NUM_COUNT) throw InputCountException()
        }
        winLottoNumbers
    } catch (e: Exception) {
        showError(e)
        throw IllegalArgumentException()
    }
}

fun readWinBonusNumber(winLottoNumbers: List<Int>): Int {
    return try {
        val winBonusNumber = readLine().toInt()
        if (winLottoNumbers.find { it == winBonusNumber } != null) {
            throw DuplicateInputException()
        }
        winBonusNumber
    } catch (e: Exception) {
        showError(e)
        throw IllegalArgumentException()
    }
}
