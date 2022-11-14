package lotto

import message.ScoreMessage

class PrintScore {

    fun printWinningScore(winningCounts: MutableList<Int>) {
        println(ScoreMessage.SCORE_TITLE.message)
        println(ScoreMessage.SCORE_LINE.message)
        println("${ScoreMessage.SCORE_THREE.message}${winningCounts[3]}개")
        println("${ScoreMessage.SCORE_FOUR.message}${winningCounts[4]}개")
        println("${ScoreMessage.SCORE_FIVE.message}${winningCounts[5]}개")
        println("${ScoreMessage.SCORE_FIVE_BONUS.message}${winningCounts[7]}개")
        println("${ScoreMessage.SCORE_SIX.message}${winningCounts[6]}개")
    }

    fun printWinningRate(winningCounts: MutableList<Int>, money: Int) {
        var totalPrice = 5000 * winningCounts[3] + 50000 * winningCounts[4] + 1500000 * winningCounts[5]
        +2000000000 * winningCounts[6] + 30000000 * winningCounts[7]
        var percent = totalPrice / money.toFloat() * 100
        println("총 수익률은 " + "%.1f".format(percent) + "%입니다.")
    }
}