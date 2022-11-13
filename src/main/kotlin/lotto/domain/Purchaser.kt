package lotto.domain

data class Purchaser(val amount: Int?) {
    var ticket = 0
        get() = amount?.div(1000) ?: 0
        private set

    var totalPrize = 0
    var resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
    var rateOfReturn: Float = 0.0F
        get() = (totalPrize * 10000 / (amount ?: 1) / 100.0F)
        private set
    var lotto: List<Lotto> = emptyList()

    init {
        requireNotNull(amount) { "[ERROR] Required value was null." }
        require(amount % 1000 == 0) { "[ERROR] Required value must be a multiple of 1000" }
    }

    fun calculateResult(winningLotto: WinningLotto) {
        lotto.map {
            resultRank[winningLotto.getRank(it.toList()) - 1] += 1
            totalPrize += winningLotto.getPrize(it.toList())
        }
    }
}
