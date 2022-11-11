package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(amount: String) {
    private var lottoCount = 0
    private val lottery = mutableListOf<Lotto>()

    init {
        validateType(amount)
        validateRemainder(amount)
        lottoCount = calculateLottoCount(amount)
    }

    fun validateType(amount: String) {
        val typeCount = amount.filter { unit ->
            unit in '0'..'9'
        }
        require(typeCount.length == amount.length) {
            throw IllegalArgumentException(ErrorMessage.intError(Constant.LOTTO_AMOUNT))
        }
    }

    fun validateRemainder(amount: String) = require(amount.toInt() % Constant.LOTTO_PRICE == Constant.ZERO) {
        throw IllegalArgumentException(ErrorMessage.unitError(Constant.LOTTO_AMOUNT))
    }

    fun pickNewLotto(count: Int) {
        for (index in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Constant.START_LOTTO_RANGE,
                Constant.END_LOTTO_RANGE,
                Constant.LOTTO_COUNT
            )
            lottery.add(Lotto(numbers))
        }
    }

    private fun calculateLottoCount(amount: String) = amount.toInt() / Constant.LOTTO_PRICE

    fun getLottoCount() = lottoCount

    fun getLottoNumbers() = lottery.forEach { lotto ->
        lotto.printLottoNumber()
    }

    fun getTotalRank(winningNumber: List<Int>, bonusNumber: Int): List<Int> {
        val rank = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
        lottery.forEach { lotto ->
            val rankIndex = lotto.confirmWinning(winningNumber, bonusNumber)
            rank[rankIndex]++
        }
        return rank
    }
}