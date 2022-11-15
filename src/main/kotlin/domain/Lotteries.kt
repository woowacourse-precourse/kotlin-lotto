package domain

class Lotteries(lotteriesNumber: List<List<Int>>) {

    private val randomLotteries = mutableListOf<Lotto>()

    init {
        lotteriesNumber.forEach {
            randomLotteries.add(Lotto(it))
        }
    }

    fun setRandomLotteries(lotteriesNumber: List<List<Int>>) {
        lotteriesNumber.forEach { randomLotteries.add(Lotto(it)) }
    }

    fun getRandomLotteries(): List<Lotto> = randomLotteries

    fun getNumberOfWinners(winningLottery: WinningLottery): Map<Rank, Int> {
        val winners = HashMap<Rank, Int>()
        Rank.values().forEach { winners[it] = INITIAL_RANK }
        winners.toMutableMap()
        randomLotteries.forEach {
            val rank = winningLottery.getRank(it)
            putCountToWinner(winners, rank)
        }
        return winners
    }

    private fun putCountToWinner(winners: MutableMap<Rank, Int>, rank: Rank) {
        if (rank != Rank.NOTHING) {
            winners[rank] = winners[rank]!! + 1
        }
    }

    companion object {
        private const val INITIAL_RANK = 0
    }
}
