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
    lottoOrganizer.inputWinLottoNumber()
    lottoOrganizer.printInputLottoBonusNumber()
    lottoOrganizer.inputBonusLottoNumber()


}



private fun printInputLottoBuyPrice() {
    println(LottoProcessStatement.INPUT_LOTTO_BUY_PRICE)
}

