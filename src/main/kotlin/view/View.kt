package view

import lotto.Ranking
import utils.Messages

class View(){

    fun buyPriceInquireMessage() {
        println(Messages.BUY_PRICE_INQUIRE_MESSAGE)
    }

    fun tellNumOfLotto(numOfLotto: Int) {
        println("$numOfLotto" + Messages.BUY_AMOUNT_MESSAGE)
    }

    fun printEachLotto(doubleLottos: MutableList<List<Int>>) {
        for (i in 0 until doubleLottos.size) {
            println(doubleLottos[i])
        }
    }

    fun answerNumbersMessage() {
        println(Messages.ANSWER_NUMBERS_MESSAGE)
    }

    fun bonusNumberMessage() {
        println(Messages.BONUS_NUMBER_MESSAGE)
    }

    fun printStatsRank(winList: MutableList<Int>) {
        println(Messages.STATICS_TITLE_MESSAGE)
        println(Messages.STATICS_SPLITTER_MESSAGE)
        Ranking.Rank.FIFTH.print(winList)
        Ranking.Rank.FOURTH.print(winList)
        Ranking.Rank.THIRD.print(winList)
        Ranking.Rank.SECOND.print(winList)
        Ranking.Rank.FIRST.print(winList)
    }

    fun printStatsRevenue(revenuePercent: Float) {
        println(Messages.STATICS_REVENUE_PREFIX_MESSAGE + "$revenuePercent" + Messages.STATICS_REVENUE_SUFFIX_MESSAGE) // 여기에 수익률 수치 넣기
    }
}
