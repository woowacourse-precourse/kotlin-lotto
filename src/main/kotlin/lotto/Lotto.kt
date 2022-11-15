package lotto

import enterprise.LOTTO_NUM_COUNT
import enterprise.LOTTO_NUM_RANGE_END
import enterprise.SameLottoResult
import exception.DuplicateInputException
import util.ErrorType
import util.printErrorMessage
import util.showError
import winlotto.WinLotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUM_COUNT) {
            printErrorMessage(ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT)
        }
        lottoNumberDuplicationCheck()
    }

    private fun lottoNumberDuplicationCheck() {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        numbers.forEach {
            if (used[it]) {
                showError(DuplicateInputException())
                throw IllegalArgumentException()
            }
            used[it] = true
        }
    }

    fun matchLotto(winLotto: WinLotto): SameLottoResult {

        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        var lottoSameCount = 0
        var isBonusSame = false
        val winLottoNumbers = winLotto.numbers

        winLottoNumbers.forEach {
            used[it] = true
        }

        numbers.forEach {
            if (used[it]) {
                if (winLottoNumbers[winLottoNumbers.lastIndex] == it) isBonusSame = true
                else lottoSameCount++
            }
        }
        return SameLottoResult(lottoSameCount, isBonusSame)
    }
}