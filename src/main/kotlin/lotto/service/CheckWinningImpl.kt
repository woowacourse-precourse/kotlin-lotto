package lotto.service

interface CheckWinning {
    fun winningCount(checkWinningNumber: Int): MutableList<Int>
    fun printResult(resultWinning: MutableList<Int>)
}

class CheckWinningImpl : CheckWinning {
    override fun winningCount(checkWinningNumber: Int): MutableList<Int> {
        val resultWinning = mutableListOf(0, 0, 0, 0, 0)
        when (checkWinningNumber) {
            3 -> resultWinning[0] += 1
            4 -> resultWinning[1] += 1
            5 -> resultWinning[2] += 1
            6 -> resultWinning[4] += 1
            7 -> resultWinning[3] += 1
        }
        return resultWinning
    }

    override fun printResult(resultWinning: MutableList<Int>) {
        println("3개 일치 (5,000원) - " + resultWinning[0] + "개")
        println("4개 일치 (50,000원) - " + resultWinning[1] + "개")
        println("5개 일치 (1,500,000원) - " + resultWinning[2] + "개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultWinning[3] + "개")
        println("6개 일치 (2,000,000,000원) - " + resultWinning[4] + "개")
    }
}