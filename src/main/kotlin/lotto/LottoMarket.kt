package lotto

import lotto.constant.LOTTO_PRICE
import lotto.util.readPaidMoney

class LottoMarket(
    private val lottoFactory: LottoFactory,
) {
    private fun payMoney(): Int {
        println("로또 구입 금액을 입력해 주세요.")
        return readPaidMoney()
    }

    private fun getLottoCount(paidMoney: Int): Int = paidMoney / LOTTO_PRICE

    fun buyLotties(): List<List<Int>> {
        val paidMoney = payMoney()
        val lottoCount = getLottoCount(paidMoney)
        return lottoFactory.makeLotties(lottoCount)
    }
}