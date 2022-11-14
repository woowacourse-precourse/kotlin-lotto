package lotto

import lotto.constants.MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG
import lotto.constants.MAKE_LOTTO_NUM_SIZE_ERROR_MSG

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { println(MAKE_LOTTO_NUM_SIZE_ERROR_MSG) }
        require(numbers.distinct().size == 6) { println(MAKE_LOTTO_NUM_DUPLICATION_ERROR_MSG) }
    }

    fun printLottoWinNum() {
        println(numbers.sorted().joinToString(", ", "[", "]"))
    }

    fun calcWin(lottoWinNums: LottoWinNums): Int {
        val bonus = numbers.contains(lottoWinNums.bonusNum)
        var numOfCorrect = numbers.count { lottoWinNums.winNums.contains(it) }

        if (numOfCorrect == 6) {
            numOfCorrect = 7
        }

        if (numOfCorrect == 5 && bonus) {
            numOfCorrect = 6
        }

        return numOfCorrect - 3
    }


}
