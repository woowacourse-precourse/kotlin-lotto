package lotto

class LottoMachine(private val customerBuyLottoCount: Int) {
    fun printCustomerBuyLottoCount() {
        println("${customerBuyLottoCount / 1000}" + LottoProcessStatement.COUNT_LOTTO_BUY + "\n")
    }

}