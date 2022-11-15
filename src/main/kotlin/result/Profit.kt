package result

import lotto.Lotto
import util.Game

class Profit {
    fun printTotalProfit(lottoNumbersList: MutableList<List<Int>>, winningNumbers: List<Int>, bonusNumber: String, lottoPrice: String){
        val winningResult = Lotto(winningNumbers).calculateWinningResult(lottoNumbersList, winningNumbers, bonusNumber)
        val winnings = winningResult[0]*5000 + winningResult[1]*50000 + winningResult[2]*1500000 + winningResult[3]*30000000 + winningResult[4]*2000000000
        val totalProfit = winnings.toDouble() / lottoPrice.toDouble() * 100
        print(Game.TOTAL_PROFIT_1.message.format(totalProfit))
        print(Game.TOTAL_PROFIT_2.message)
    }
}