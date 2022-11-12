package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.ConsoleMessage
import lotto.util.Constant
import lotto.util.ErrorMessage

class LottoMachine(amount: String) {
    private var lottoCount = 0
    private val lottery = mutableListOf<Lotto>()

    init {
        validateType(amount)
        validateRemainder(amount)
        lottoCount = calculateLottoCount(amount)
    }

    fun validateType(amount: String) {
        val typeCount = amount.filter {
            it in '0'..'9'
        }
        require(typeCount.length == amount.length) {
            ErrorMessage.intError(Constant.LOTTO_AMOUNT)
        }
    }

    fun validateRemainder(amount: String) = require(amount.toInt() % Constant.LOTTO_PRICE == Constant.ZERO) {
        ErrorMessage.unitError(Constant.LOTTO_AMOUNT)
    }

    fun pickNewLotto(count: Int) {
        for (index in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Constant.START_LOTTO_RANGE, Constant.END_LOTTO_RANGE, Constant.LOTTO_COUNT
            )
            lottery.add(Lotto(numbers))
        }
    }

    private fun calculateLottoCount(amount: String) = amount.toInt() / Constant.LOTTO_PRICE

    fun getLottoCount() = lottoCount

    fun getLottery() = lottery

    fun getTotalRank(winningNumber: List<Int>, bonusNumber: Int): List<Int> {
        val rank = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
        lottery.forEach {
            val rankIndex = it.confirmWinning(winningNumber, bonusNumber)
            rank[rankIndex]++
        }
        return rank
    }
}