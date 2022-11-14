package lotto

import Util.Game
import Util.Ranking

class WinningPrinter(private val winningList: List<Int>) {
    fun printWinning() {
        println(Game.WINNING_LIST_OUTPUT.message)
        println(Game.LINE_OUTPUT.message)
        for (rank in Ranking.FIFTH.ranking downTo Ranking.FIRST.ranking) {
            printWinningList(rank)
        }
    }

    private fun printWinningList(rank: Int) {
        when (rank) {
            Ranking.FIFTH.ranking -> println(Game.FIFTH_RANKING_OUTPUT.message.format(winningList[rank]))
            Ranking.FOURTH.ranking -> println(Game.FORTH_RANKING_OUTPUT.message.format(winningList[rank]))
            Ranking.THIRD.ranking -> println(Game.THIRD_RANKING_OUTPUT.message.format(winningList[rank]))
            Ranking.SECOND.ranking -> println(Game.SECOND_RANKING_OUTPUT.message.format(winningList[rank]))
            Ranking.FIRST.ranking -> println(Game.FIRST_RANKING_OUTPUT.message.format(winningList[rank]))
        }
    }
}