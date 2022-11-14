package domain

class LottoGame(private val theNumberOfLotto: Int) {
    private lateinit var lotteries: Lotteries
    private lateinit var winningLottery: WinningLottery

    fun createLotto() {
        val lottoNumber = mutableListOf<List<Int>>()
        for (i in 0 until theNumberOfLotto) {
            lottoNumber.add(RandomLottoGenerator().getRandomLotto())
        }
        lotteries = Lotteries(lottoNumber)
    }

    fun createTestLotto() {
        val lottoNumber = mutableListOf<List<Int>>()
        for (i in 0 until theNumberOfLotto) {
            lottoNumber.add(listOf(1, 2, 3, 11, 12, 13))
        }
        lotteries = Lotteries(lottoNumber)
    }

    fun createWinningLotto(winningNumbers: List<Int>, bonusBall: Int) {
        winningLottery = WinningLottery(winningNumbers, bonusBall)
    }

    fun makeWinner(): Map<Rank, Int> {
        return lotteries.getNumberOfWinners(winningLottery)
    }

    fun makeRankPercent(rankResult: MutableMap<Rank, Int>): Double {
        var incomeRate = 0
        for (rank in rankResult.keys) {
            incomeRate += rankResult[rank]?.times(rank.reward) ?: 0
        }
        return incomeRate.toDouble() / (theNumberOfLotto * 1000)
    }
}
