package util

import camp.nextstep.edu.missionutils.Console.readLine
import constant.LOTTO_MIN_GRADE
import constant.LOTTO_NUM_COUNT
import constant.LOTTO_NUM_RANGE_END
import exception.DivisibleMoneyException
import exception.DuplicateInputException
import exception.InputCountException

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
            winLottoNumbers.forEach {
                checkOutOfLottoBound(it)
            }
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
        checkOutOfLottoBound(winBonusNumber)
        winBonusNumber
    } catch (e: Exception) {
        showError(e)
        throw IllegalArgumentException()
    }
}

private fun checkOutOfLottoBound(lottoNumber: Int) {
    if (lottoNumber !in LOTTO_MIN_GRADE..LOTTO_NUM_RANGE_END) throw ArrayIndexOutOfBoundsException()
}