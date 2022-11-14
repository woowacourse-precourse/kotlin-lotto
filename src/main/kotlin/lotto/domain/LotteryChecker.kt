package lotto.domain

class LotteryChecker {

    init {
        for (rank in Rank.values()) winner[rank] = 0
    }

    fun checkLotteryNumber(winningLottery: WinningLottery, lottoTicket: List<Lotto>) {
        lottoTicket.forEach { Lotto ->
            val result = matchLottoNumbers(winningLottery, Lotto.getNumbers())
            val rank = Rank.valueOf(matchedCount = result.first, checkBonus = result.second)
            addCount(rank)
        }
    }

    private fun addCount(rank: Rank) {
        winner[rank] = winner.getOrDefault(rank, 0) + 1
    }

    private fun matchLottoNumbers(winningLottery: WinningLottery, lotto: List<Int>): Pair<Int, Boolean> {
        var count = 0
        var checkBonus = false
        winningLottery.getNumber().forEach { number ->
            if (lotto.contains(number)) count++
        }

        if (lotto.contains(winningLottery.getBonusNumber())) { checkBonus = true }

        return Pair(count, checkBonus)
    }

    fun getWinnerScore(rank: Rank): Int {
        return winner[rank]!!
    }

    fun getTotalWinnerPrice(): Long {
        var totalPrice: Long = 0
        for (rank in Rank.values()) {
            totalPrice += rank.getPrice() * winner[rank]!!
        }

        return totalPrice
    }

    companion object {
        private val winner = mutableMapOf<Rank, Int>()
    }
}
