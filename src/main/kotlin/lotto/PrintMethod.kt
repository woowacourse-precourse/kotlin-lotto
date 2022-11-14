package lotto

import lotto.Constant.Companion.count
import lotto.Constant.Companion.fifthReward
import lotto.Constant.Companion.fifthRewardMessage
import lotto.Constant.Companion.firstReward
import lotto.Constant.Companion.firstRewardMessage
import lotto.Constant.Companion.fourthReward
import lotto.Constant.Companion.fourthRewardMessage
import lotto.Constant.Companion.lottoCost
import lotto.Constant.Companion.percent
import lotto.Constant.Companion.printBuyMessage
import lotto.Constant.Companion.printRankMessage
import lotto.Constant.Companion.secondReward
import lotto.Constant.Companion.secondRewardMessage
import lotto.Constant.Companion.thirdReward
import lotto.Constant.Companion.thirdRewardMessage
import lotto.Constant.Companion.yieldMessage
import lotto.Constant.Companion.yieldEndMessage

class PrintMethod {
    fun printBuyAmount(amount: Int) {
        println("${amount % lottoCost}" + printBuyMessage)
    }

    fun printWallet(wallet: MutableList<Int>) {
        println(wallet)
    }

    fun printRanking(rank: MutableList<Int>) {
        val rankMessage = listOf<String>(fifthRewardMessage, fourthRewardMessage, thirdRewardMessage, secondRewardMessage, firstRewardMessage)

        rank.reverse()
        println(printRankMessage)
        for (idx in rank.indices) println(rankMessage[idx] + rank[idx] + count)
    }

    fun printYield(rank: MutableList<Int>, buyAmount: Int) {
        var yield:Long = 0
        val rankReward = listOf<Long>(firstReward, secondReward, thirdReward, fourthReward, fifthReward)

        rank.reverse()
        for (idx in rank.indices) {
            `yield` += rankReward[idx] * rank[idx]
            println(`yield`)
        }
        println(yieldMessage + "%.1f".format(`yield`.toDouble() / buyAmount * percent) + yieldEndMessage)
    }
}