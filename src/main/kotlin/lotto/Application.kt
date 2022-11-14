package lotto

val LOTTO_PRICE = 1000
val LOTTO_SIZE = 6

fun main() {
    var buyer = Buyer()
    var lottoCnt = buyer.getPurchaseAmount()

    var seller = Seller()
    seller.generateLotto(lottoCnt)
    seller.getWinningNumber()

    var lotto = Lotto(Seller.winningNumber)
    lotto.getWinningLotto()
}
