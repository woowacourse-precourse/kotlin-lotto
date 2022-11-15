package lotto.service

import lotto.util.OutputMessage

interface CheckWinning {
    fun winningCount(checkWinningNumber: Int): MutableList<Int>
    fun printResult(resultWinning: MutableList<Int>)
}

class CheckWinningReal : CheckWinning {
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
        OutputMessage().winningMsg(resultWinning)}
}