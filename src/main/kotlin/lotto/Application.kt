package lotto

fun main() {
    val lottoCustomer = LottoCustomer()
    val customerBuyCount = lottoCustomer.customerLottoBuyPriceInput()

    val lottoMachine = LottoMachine(customerBuyCount)

}
