package result

import lotto.Lotto
import util.Game

class WinningResult {
    fun printWinningResult(lottoNumbersList: MutableList<List<Int>>, winningNumbers: List<Int>, bonusNumber: String, lottoPrice: String){
        val winningResult = Lotto(winningNumbers).calculateWinningResult(lottoNumbersList, winningNumbers, bonusNumber)
        println(Game.WINNING_RESULT.message)
        println(Game.RANKING_FIFTH.message.format(winningResult[0]))
        println(Game.RANKING_FOURTH.message.format(winningResult[1]))
        println(Game.RANKING_THIRD.message.format(winningResult[2]))
        println(Game.RANKING_SECOND.message.format(winningResult[3]))
        println(Game.RANKING_FIRST.message.format(winningResult[4]))
        Profit().printTotalProfit(lottoNumbersList, winningNumbers, bonusNumber, lottoPrice)
    }
}