package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoSeller() {

    private fun issueLottery(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun sellLottery(count: Int): List<Lotto> {
        val sellLotteries = mutableListOf<Lotto>()
        for (i in 0 until count) {
            sellLotteries.add(Lotto(issueLottery().sorted()))
        }
        return sellLotteries
    }

    fun sellLottoCount(money: Int): Int = money / LOTTO_SELL_PRICE

    companion object {
        const val LOTTO_SELL_PRICE = 1000
    }
}