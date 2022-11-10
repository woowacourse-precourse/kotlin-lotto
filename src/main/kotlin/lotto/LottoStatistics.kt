package lotto

class LottoStatistics {
    fun statisticsLotto(
        lotteryTickets: List<Lotto>, winning: List<Int>, bonus: Int,
    ): List<Int> {
        val result = mutableListOf(0, 0, 0, 0, 0, 0)
        lotteryTickets.forEach { result[it.matchResult(winning, bonus).index]++ }
        return result.subList(0, 5)
    }
}