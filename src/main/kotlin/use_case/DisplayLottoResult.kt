package use_case

import _enum.LottoEnum
import kotlin.math.roundToLong

class DisplayLottoResult(
    buyLotto: BuyLotto,
    getCorrectLotto: GetCorrectLotto
) {
    private var totalPrice = 0L
    private val lottoList = buyLotto.getLottoList()
    private val correct = getCorrectLotto.getCorrectValue()
    private val bonus = getCorrectLotto.getBonusValue()

    init {
        compareLottos()
        displayStatcis()
        displayProfitRate()
    }

    private fun compareLottos() {
        for (lotto in lottoList) {
            lotto.compareLotto(correct, bonus)
            totalPrice += lotto.getTotalPrice()
        }
    }

    private fun displayStatcis() {
        println("\n당첨통계\n---")
        for (i in LottoEnum.values()) {
            println("${i.message} - ${i.count}개")
        }
    }

    private fun displayProfitRate() {
        var profitRate = totalPrice/(lottoList.size*10.0)
        profitRate = (profitRate*10.0.roundToLong())/10.0
        val formatted = String.format("%.1f", profitRate)
        println("총 수익률은 ${formatted}%입니다.")
    }
}