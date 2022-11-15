package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}

class AutomaticLotteryTickets(private val purchaseAmount: Int) : Iterator<List<Int>> {
    private val tickets = arrayListOf<List<Int>>()
    private var index = 0

    init {
        require(purchaseAmount % 1000 == 0 && purchaseAmount > 0) { "[ERROR] 구입 금액이 1000원 단위가 아님" }
        for (i in 0 until purchaseAmount / 1000)
            tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    fun countTickets(): Int {
        return tickets.count()
    }

    override fun toString(): String {
        return tickets.toString()
    }

    override fun next(): List<Int> {
        return tickets[index++]
    }

    override fun hasNext(): Boolean {
        return index < tickets.count()
    }
}

class LottoWinningStat(
    private val lotto: Lotto,
    private val bonusNumber: Int,
    private val tickets: AutomaticLotteryTickets
) {

    private fun validateIsIncludedInLotto(number: Int, lotto: Lotto) {
        if (lotto.contains(number)) {
            println("[ERROR] 보너스 번호가 당첨 번호와 중복됨")
            throw IllegalArgumentException()
        }
    }
}