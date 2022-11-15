package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Messages.Companion.BONUS_NUMBER_INPUT_MESSAGE
import lotto.Messages.Companion.EARNINGS_RATE_MESSAGE
import lotto.Messages.Companion.FIFTH_PRIZE_RESULT
import lotto.Messages.Companion.FIRST_PRIZE_RESULT
import lotto.Messages.Companion.FORTH_PRIZE_RESULT
import lotto.Messages.Companion.NUMBER_OF_LOTTOS_MESSAGE
import lotto.Messages.Companion.PAYMENT_INPUT_MESSAGE
import lotto.Messages.Companion.SECOND_PRIZE_RESULT
import lotto.Messages.Companion.STATS_TITLE
import lotto.Messages.Companion.THIRD_PRIZE_RESULT
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
            sb.append(FIFTH_PRIZE_RESULT.format(rankResults[WinningRank.FIFTH])).append('\n')
            sb.append(FORTH_PRIZE_RESULT.format(rankResults[WinningRank.FORTH])).append('\n')
            sb.append(THIRD_PRIZE_RESULT.format(rankResults[WinningRank.THIRD])).append('\n')
            sb.append(SECOND_PRIZE_RESULT.format(rankResults[WinningRank.SECOND])).append('\n')
            sb.append(FIRST_PRIZE_RESULT.format(rankResults[WinningRank.FIRST])).append('\n')
            sb.append(EARNINGS_RATE_MESSAGE.format(earningsRate))
            print(sb.toString())
        }
    }

}