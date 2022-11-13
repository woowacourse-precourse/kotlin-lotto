package lotto

import lotto.service.LottoService
import lotto.userinterface.UserInterface

fun main() {
    val purchaseAmount = UserInterface.askPurchaseAmount()
    val lotteries = LottoService.purchaseLotteries(purchaseAmount)
    UserInterface.showPurchaseResult(lotteries)
}
