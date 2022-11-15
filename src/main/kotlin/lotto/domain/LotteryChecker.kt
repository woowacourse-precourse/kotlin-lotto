package lotto.domain

class LotteryChecker {

    init {
        for (rank in Rank.values()) winner[rank] = 0
    }

    fun checkLotteryNumber(winningLottery: WinningLottery, lottoTicket: List<Lotto>) {
        lottoTicket.forEach { Lotto ->
            val count = countRightLottoNumbers(winningLottery.getNumber(), Lotto.getNumbers())
            val bonus = isBonusNumber(winningLottery, Lotto.getNumbers())
            val rank = Rank.valueOf(count, bonus)

            addCount(rank)
        }
    }

    private fun countRightLottoNumbers(winningLotto: List<Int>, lotto: List<Int>): Int {
        var count = 0
        winningLotto.forEach { number ->
            if (lotto.contains(number)) count++
        }

        return count
    }
    private fun isBonusNumber(winningLottery: WinningLottery, lotto: List<Int>): Boolean {
        return lotto.contains(winningLottery.getBonusNumber())
    }

    private fun addCount(rank: Rank) {
        winner[rank] = winner.getOrDefault(rank, 0) + 1
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
