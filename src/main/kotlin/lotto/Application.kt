package lotto

fun main() {
    printInputLottoBuyPrice()
    val lottoCustomer = LottoCustomer()
    val customerBuyPrice = lottoCustomer.customerLottoBuyPriceInput()

    val lottoMachine = LottoMachine(customerBuyPrice)
    lottoMachine.printCustomerBuyLottoCount()
    val producedLottoNumbers = lottoMachine.produceLottoNumbers()

    val lottoOrganizer = LottoOrganizer(producedLottoNumbers)
    lottoOrganizer.printInputLottoWinNumber()


}



private fun printInputLottoBuyPrice() {
    println(LottoProcessStatement.INPUT_LOTTO_BUY_PRICE)
}

