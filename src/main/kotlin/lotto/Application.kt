package lotto

fun main() {
    val lottoCustomer = LottoCustomer()
    val customerBuyPrice = lottoCustomer.customerLottoBuyPriceInput()

    val lottoMachine = LottoMachine(customerBuyPrice)
    lottoMachine.printCustomerBuyLottoCount()
    lottoMachine.produceLottoNumbers()


}
