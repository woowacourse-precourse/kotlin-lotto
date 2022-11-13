package lotto.domain

class Purchaser(amount: Int?) {
    var amount = 0
        private set
    var totalPrize = 0
    var resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
    var rateOfReturn: Float = 0.0F
        get() = (totalPrize * 10000 / (amount) / 100.0F)
        private set
    var lotto: List<Lotto> = emptyList()

    init {
        requireNotNull(amount) { "[ERROR] Required value was null." }
        this.amount = amount
    }

    fun calculateResult(winningLotto: WinningLotto) {
        lotto.map {
            resultRank[winningLotto.getRank(it.toList()) - 1] += 1
            totalPrize += winningLotto.getPrize(it.toList())
        }
    }
}
