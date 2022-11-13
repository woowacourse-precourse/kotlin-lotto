package lotto

import lotto.constant.LOTTO_PRICE
import lotto.util.readPaidMoney

class LottoMarket(
    private val lottoFactory: LottoFactory,
) {
    fun payMoney(): Int {
        println("로또 구입 금액을 입력해 주세요.")
        return readPaidMoney()
    }

    private fun getLottoCount(paidMoney: Int): Int = paidMoney / LOTTO_PRICE

    fun sellLotties(paidMoney: Int): List<Lotto> {
        val lottoCount = getLottoCount(paidMoney)
        println("${lottoCount}개를 구매했습니다.")
        return lottoFactory.makeLotties(lottoCount).map {
            println(it)
            Lotto(it)
        }
    }
}