package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Messages.Companion.BONUS_NUMBER_INPUT_MESSAGE
import lotto.Messages.Companion.EARNINGS_RATE_MESSAGE
import lotto.Messages.Companion.MATCH_3
import lotto.Messages.Companion.MATCH_4
import lotto.Messages.Companion.MATCH_5
import lotto.Messages.Companion.MATCH_5_BONUS
import lotto.Messages.Companion.MATCH_6
import lotto.Messages.Companion.NUMBER_OF_LOTTOS_MESSAGE
import lotto.Messages.Companion.PAYMENT_INPUT_MESSAGE
import lotto.Messages.Companion.STATS_TITLE
import lotto.Messages.Companion.WINNING_NUMBER_INPUT_MESSAGE

class View {

    companion object {
        fun getPaymentAmount(): String {
            println(PAYMENT_INPUT_MESSAGE)
            return Console.readLine()
        }

        fun printNumberOfLottos(number: Int) {
            println(NUMBER_OF_LOTTOS_MESSAGE.format(number))
        }

        fun printLottos(lottos: ArrayList<Lotto>) {
            lottos.forEach {
                println(it.getNumbers())
            }
        }

        fun getWinningNumber(): String {
            println(WINNING_NUMBER_INPUT_MESSAGE)
            return Console.readLine()
        }

        fun getBonusNumber(): String {
            println(BONUS_NUMBER_INPUT_MESSAGE)
            return Console.readLine()
        }

        fun printResultStats(rankResults: Map<WinningRank, Int>, earningsRate: String) {
            val sb = StringBuilder()
            sb.append(STATS_TITLE).append('\n')
            sb.append(MATCH_3.format(rankResults[WinningRank.FIFTH])).append('\n')
            sb.append(MATCH_4.format(rankResults[WinningRank.FORTH])).append('\n')
            sb.append(MATCH_5.format(rankResults[WinningRank.THIRD])).append('\n')
            sb.append(MATCH_5_BONUS.format(rankResults[WinningRank.SECOND])).append('\n')
            sb.append(MATCH_6.format(rankResults[WinningRank.FIRST])).append('\n')
            sb.append(EARNINGS_RATE_MESSAGE.format(earningsRate))
            print(sb.toString())
        }
    }

}