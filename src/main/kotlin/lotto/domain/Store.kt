package lotto.domain

class Store {
    fun buyLotto(numberOfTicket: Int): List<List<Int>> {
        return 0.until(numberOfTicket).map { NumberGenerator().createRandomNumbers() }
    }
}
