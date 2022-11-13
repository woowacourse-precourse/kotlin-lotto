package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber: Int): Rank {
        return Rank.FIRST
    }

    fun getTicket(): String {
        return ""
    }
}
