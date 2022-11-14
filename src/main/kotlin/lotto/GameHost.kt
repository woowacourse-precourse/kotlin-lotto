package lotto

import lotto.LottoPhrases.PURCHASE_AMOUNT_PHRASES
import lotto.lottoshop.LottoShop

class GameHost(private val customer: Customer, private val lottoShop: LottoShop) {

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
}
