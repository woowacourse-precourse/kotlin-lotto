package lotto.domain

object LottoShop {

    private const val LOTTO_PRICE = 1000

    fun lottoPrice() = LOTTO_PRICE

    fun purchaseLotteries(purchaseAmount: Int): List<Lotto> {
        validatePurchaseAmountDivisible(purchaseAmount)
        val purchaseCount = purchaseAmount / LOTTO_PRICE
        return (1..purchaseCount).map { LottoFactory.createRandomLotto() }
    }

    private fun validatePurchaseAmountDivisible(purchaseAmount: Int) =
        require(purchaseAmount % LOTTO_PRICE == 0)
}