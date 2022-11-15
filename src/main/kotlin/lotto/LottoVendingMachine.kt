package lotto

import util.Printer

class LottoVendingMachine(
    private val user: User,
    private val machine: Machine,
    private val printer: Printer
) {
    fun execution() {
        purchaseLotto()
        issueLotto()
    }

    private fun purchaseLotto() {
        printer.printPurchaseMessage()
        user.inputMoney()
    }

    private fun issueLotto() {
        val lottoCount = user.getLottos()
        printer.printCountLotto(lottoCount)

    }
}