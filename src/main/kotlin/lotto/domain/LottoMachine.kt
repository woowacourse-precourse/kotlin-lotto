package lotto.domain

class LottoMachine(private val generator: Generator) {
    private val tickets = mutableListOf<Lotto>()

    fun publish(money: Int): List<Lotto> {
        return tickets
    }
}