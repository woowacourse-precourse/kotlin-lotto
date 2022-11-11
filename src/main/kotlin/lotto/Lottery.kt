package lotto

class Lottery(
    private val computer: Computer,
    private val calculator: Calculator,
    private val buyer: Buyer,
    private val printer: Printer
) {
    fun start() {
        purchaseLotto()
    }

    private fun purchaseLotto(){
        printer.printAmountMessage()
        val amount = buyer.enterAmount()
    }
}