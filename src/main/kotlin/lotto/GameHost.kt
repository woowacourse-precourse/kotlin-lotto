package lotto

import lotto.LottoPhrases.LOTTO_COUNT_PHRASES
import lotto.LottoPhrases.PURCHASE_AMOUNT_PHRASES
import lotto.LottoRule.LOTTO_PRICE
import lotto.lottoshop.LottoShop
import lotto.lottoshop.lottomachine.LottoMachine

class GameHost(
    private val customer: Customer,
    private val lottoShop: LottoShop,
    private val lottoMachine: LottoMachine
) {
    private lateinit var lottos: List<Lotto>

    fun progressPurchaseAmount() {
        printPurchaseAmountPhrases()
        val unprocessedPurchaseAmount = customer.getPurchaseAmount()
        val processedPurchaseAmount = lottoShop.getValidatePurchaseAmount(unprocessedPurchaseAmount)
        Customer.updatePurchaseAmount(processedPurchaseAmount)
        println()
    }

    private fun printPurchaseAmountPhrases() {
        println(PURCHASE_AMOUNT_PHRASES)
    }

    fun progressDrawLotto() {
        printLottoCountPhrases()
        lottos = drawLottos()
        printLottos(lottos)
    }

    private fun printLottoCountPhrases() {
        println((Customer.purchaseAmount / LOTTO_PRICE).toString() + LOTTO_COUNT_PHRASES)
    }

    private fun drawLottos(): List<Lotto> {
        var lottos = listOf<Lotto>()
        for (purchaseCount in 1..Customer.purchaseAmount / LOTTO_PRICE) lottos += lottoMachine.drawLotto()
        return lottos
    }

    private fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) println(lotto.getLottoNumbers())
    }
}
