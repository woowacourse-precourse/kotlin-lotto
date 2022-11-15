package lotto

class ResultLotto {
    init {
        println(Output.Result.message)
        println("---")
    }

    fun result(
        lottoList: List<List<Int>>,
        winningNumber: List<Int>,
        bonusNumber: Int,
    ): Long {
        var money = 0L
        val prizeResult = mutableListOf(0, 0, 0, 0, 0)

        for (lotto in lottoList) {
            val rank = compareWinningNumber(lotto, winningNumber)
            val bonus = compareBonusNumber(lotto, bonusNumber)

            when {
                rank == 3 -> {
                    prizeResult[0]++
                    money += 5_000
                }
                rank == 4 -> {
                    prizeResult[1]++
                    money += 50_000
                }
                rank == 5 -> {
                    prizeResult[2]++
                    money += 1_500_000
                }
                rank == 5 && bonus -> {
                    prizeResult[3]++
                    money += 30_000_000
                }
                rank == 6 -> {
                    prizeResult[4]++
                    money += 2_000_000_000
                }
            }
        }
        printResult(prizeResult)
        return money
    }

    private fun compareWinningNumber(lotto: List<Int>, winningNumber: List<Int>): Int {
        var match = 0
        winningNumber.forEach {
            if (lotto.contains(it)) match++
        }
        return match
    }

    private fun compareBonusNumber(lotto: List<Int>, bonusNumber: Int): Boolean {
        return lotto.contains(bonusNumber)
    }
}
