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

    lottoOrganizer.produceLottoWinHistory()


}



private fun printInputLottoBuyPrice() {
    println(LottoProcessConstValue.INPUT_LOTTO_BUY_PRICE)
}

