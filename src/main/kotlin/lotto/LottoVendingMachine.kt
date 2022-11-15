package lotto

import util.Printer

class LottoVendingMachine(
    private val user: User,
    private val printer: Printer
) {
    fun execution() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        printer.printPurchaseMessage()
        val money = user.inputMoney()
        val lottoCount = user.getLottos()
    }
}