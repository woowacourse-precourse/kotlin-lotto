package domain

class LottoGame(private val theNumberOfLotto: Int) {
    private lateinit var lotteries: Lotteries
    private lateinit var winningLottery: WinningLottery

    init {
        createLotto()
    }

    private fun createLotto() {
        val lottoNumber = mutableListOf<List<Int>>()
        for (numberOfLotto in 0 until theNumberOfLotto) {
            lottoNumber.add(RandomLottoGenerator().getRandomLotto())
        }
        lotteries = Lotteries(lottoNumber)
    }

    fun createTestLotto() {
        val lottoNumber = mutableListOf<List<Int>>()
        for (numberOfLotto in 0 until theNumberOfLotto) {
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
        var incomeRate = ZERO_INCOME_RATE
        for (rank in rankResult.keys) {
            incomeRate += rankResult[rank]?.times(rank.reward) ?: ZERO_INCOME_RATE
        }
        return incomeRate.toDouble() / (theNumberOfLotto * LOTTO_PRICE)
    }

    fun getLotteries() = lotteries.getRandomLotteries()

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val ZERO_INCOME_RATE = 0
    }
}
