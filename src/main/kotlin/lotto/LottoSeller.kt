package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoSeller() {
    private fun sellLotteryCount(money: Int): Int = money / LOTTO_SELL_PRICE

    private fun issueLottery(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun sellLottery(money: Int): List<Lotto> {
        val count = sellLotteryCount(money)
        val sellLotteries = mutableListOf<Lotto>()
        for (i in 0 until count) {
            sellLotteries.add(Lotto(issueLottery()))
        }
        return sellLotteries
    }

    companion object {
        const val LOTTO_SELL_PRICE = 1000
    }
}