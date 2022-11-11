package lotto.domain

data class Purchase(val amount: Int?) {
    var ticket = 0
        get() = amount?.div(1000) ?: 0
        private set

    init {
        requireNotNull(amount) { "[ERROR] Required value was null." }
        require(amount % 1000 == 0) { "[ERROR] Required value must be a multiple of 1000" }
    }
}
