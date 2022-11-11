package lotto.domain

data class Purchase(val amount: Int?) {
    init {
        requireNotNull(amount) { "[ERROR] Required value was null." }
        require(amount % 1000 == 0) { "[ERROR] Required value must be a multiple of 1000" }
    }
}
