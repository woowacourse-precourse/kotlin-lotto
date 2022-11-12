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

    //로또 구입 금액만큼 로또 반환
    private fun getLottoCount(paidMoney: Int): Int = paidMoney / LOTTO_PRICE

    fun buyLotties(): List<IntArray> {
        val paidMoney = payMoney()
        val lottoCount = getLottoCount(paidMoney)
        return lottoFactory.makeLotties(lottoCount)
    }
}