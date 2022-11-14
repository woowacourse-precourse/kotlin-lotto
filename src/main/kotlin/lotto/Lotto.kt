package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private var _winningsMoney = 0
    val winningsMoney get() = _winningsMoney

    val lottoStats = mutableListOf<Int>(0, 0, 0, 0, 0)
    val winningsTable = listOf(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)

    fun calculateProfit(money: Int, winnings: Int): Float = (winnings.toFloat() / money.toFloat())

    private fun countWinningNumbers(lottoTicket: List<Int>) = numbers.filter { number ->
        lottoTicket.contains(number)
    }.size

    fun checkBonusNumber(bonus: Int): Boolean = numbers.contains(bonus)

    fun checkCorrectCount(lottoTicket: List<Int>, bonus: Int) {
        var count = countWinningNumbers(lottoTicket)
        if (checkBonusNumber(bonus)) count += 1
        lottoStats[count]++
    }

    fun winningsTotal(): Int {
        var sum = 0
        lottoStats.forEachIndexed { index, cnt ->
            sum += winningsTable[index] * cnt
        }
        return sum
    }

    fun printProfit(profit: Float) = println("총 수익률은 ${"%.2f".format(profit)}입니다.")

    fun printStats() = println("\n당첨 통계\n---")

    fun printLottoResult() {
        val printResults = listOf(FIVTH, FOURTH, THIRD, SECOND, FIRST)
        printResults.forEachIndexed { index, it ->
            println("$it ${lottoStats[index]}")
        }
    }


    companion object {
        const val FIVTH = "3개 일치 (5,000원) - "
        const val FOURTH = "4개 일치 (50,000원) - "
        const val THIRD = "5개 일치 (1,500,000원) - "
        const val SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val FIRST = "6개 일치 (2,000,000,000원) - "
    }
}
