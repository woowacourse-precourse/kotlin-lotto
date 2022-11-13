package lotto.domain

data class Purchase(val amount: Int?) {
    var ticket = 0
        get() = amount?.div(1000) ?: 0
        private set

    var totalPrize = 0
    var resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
    var rateOfReturn: Float = 0.0F
        get() = (totalPrize * 10000 / (amount ?: 1) / 100.0F)
        private set

    init {
        requireNotNull(amount) { "[ERROR] Required value was null." }
        require(amount % 1000 == 0) { "[ERROR] Required value must be a multiple of 1000" }
    }
}
