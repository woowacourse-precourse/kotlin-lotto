package lotto.domain

class Store {
    fun buyLotto(amount: Int): List<List<Int>> {
        return 0.until(getTicket(amount)).map { NumberGenerator().createRandomNumbers() }
    }

    private fun getTicket(amount: Int): Int {
        require(amount % 1000 == 0) { "[ERROR] Required value must be a multiple of 1000" }
        return amount / 1000
    }
}
