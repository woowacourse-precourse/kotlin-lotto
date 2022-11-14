package lotto

val LOTTO_PRICE = 1000
val LOTTO_SIZE = 6

fun main() {
    var buyer = Buyer()
    var lottoPurchaseCount = buyer.getPurchaseAmount()

    var seller = Seller()
    seller.generateLotto(lottoPurchaseCount)
    seller.getWinningNumber()

    var lotto = Lotto(Seller.winningNumber)
    lotto.showLottoResult()
}
