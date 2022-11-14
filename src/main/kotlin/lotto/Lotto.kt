package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private var _correctCount = 0
    val correctCount get() = _correctCount

    val lottoStats = mutableListOf<Int>(0, 0, 0, 0, 0)

    fun calculateProfit(money: Int, winnings: Int): Float = (winnings.toFloat() / money.toFloat())

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
