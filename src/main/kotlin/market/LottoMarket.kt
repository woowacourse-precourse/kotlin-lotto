package market

import enterprise.LOTTO_PRICE
import lotto.Lotto
import lotto.LottoFactory
import util.readPaidMoney
import view.MarketUI

class LottoMarket(
    private val lottoFactory: LottoFactory,
    private val marketUI: MarketUI,
) {
    fun payMoney(): Int {
        marketUI.showUI(MarketUI.Companion.UI.ASK_PAY_MONEY_INPUT, null)
        return readPaidMoney()
    }

    private fun getLottoCount(paidMoney: Int): Int = paidMoney / LOTTO_PRICE

    fun sellLotties(paidMoney: Int): List<Lotto> {
        val lottoCount = getLottoCount(paidMoney)
        marketUI.showUI(
            MarketUI.Companion.UI.ANSWER_BUY_LOTTO_COUNT, lottoCount
        )
        return lottoFactory.makeLotties(lottoCount).map { numbers ->
            marketUI.showUI(
                MarketUI.Companion.UI.ANSWER_LOTTO,
                numbers
            )
            Lotto(numbers)
        }
    }
}