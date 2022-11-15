package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE

class Publisher {

    fun generateLottery(money: Money): Pair<Long, List<Lotto>> {
        val lottoCount = money.value() / LOTTO_PRICE
        val lottoNumbers = operateMachine(lottoCount)
        return Pair(lottoCount, lottoNumbers)
    }

    private fun operateMachine(lottoCount: Long): List<Lotto> {
        return LotteryMachine().operate(lottoCount)
    }
}
