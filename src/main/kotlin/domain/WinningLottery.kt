package domain

import lotto.LottoMessage

class WinningLottery(private val winningNumbers: List<Int>, private val bonusBall: Int) {

    init {
        require(bonusBall in LOTTO_MIN_BOUND..LOTTO_MAX_BOUND) { LottoMessage.LOTTERY_RANGE_ERROR }
        require(!winningNumbers.stream().anyMatch { it == bonusBall }) { LottoMessage.NO_DUPLICATED_WITH_BONUS }
    }

    fun getRank(lottery: Lotto): Rank {
        val winningCount: Int = Lotto(winningNumbers).countSameNumber(lottery)
        return Rank.getRank(winningCount, lottery.contains(bonusBall))
    }

    companion object {
        private const val LOTTO_MIN_BOUND = 1
        private const val LOTTO_MAX_BOUND = 45
    }
}
