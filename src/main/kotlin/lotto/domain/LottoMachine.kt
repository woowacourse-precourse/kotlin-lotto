package lotto.domain

class LottoMachine(private val generator: Generator) {
    private val tickets = mutableListOf<Lotto>()

    fun publish(money: Int): List<Lotto> {
        var numberOfTickets = money / 1000
        while (numberOfTickets != 0) {
            val numbers = generator.generateNumbers()
            val lotto = Lotto(numbers)
            tickets.add(lotto)
            numberOfTickets--
        }
        return tickets
    }
}