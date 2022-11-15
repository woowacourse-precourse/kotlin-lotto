package lotto

fun main() {
    printInputLottoBuyPrice()
    val lottoCustomer = LottoCustomer()
    val customerBuyPrice = lottoCustomer.customerLottoBuyPriceInput()

    val lottoMachine = LottoMachine(customerBuyPrice)
    lottoMachine.printCustomerBuyLottoCount()
    lottoMachine.produceLottoNumbers()

    printInputLottoWinNumber()
    val lottoOrganizer = LottoOrganizer()
    printInputLottoBonusNumber()


}



private fun printInputLottoBuyPrice() {
    println(LottoProcessStatement.INPUT_LOTTO_BUY_PRICE)
}

private fun printInputLottoWinNumber() {
    println(LottoProcessStatement.INPUT_LOTTO_WIN_NUMBER)
}

private fun printInputLottoBonusNumber() {
    println(LottoProcessStatement.INPUT_LOTTO_BONUS_NUMBER)
}