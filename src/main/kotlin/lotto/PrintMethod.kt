package lotto

import lotto.Constant.Companion.count
import lotto.Constant.Companion.fifthRewardMessage
import lotto.Constant.Companion.firstRewardMessage
import lotto.Constant.Companion.fourthRewardMessage
import lotto.Constant.Companion.lottoCost
import lotto.Constant.Companion.printBuyMessage
import lotto.Constant.Companion.printRankMessage
import lotto.Constant.Companion.secondRewardMessage
import lotto.Constant.Companion.thirdRewardMessage

class PrintMethod {
    fun printBuyAmount(amount: Int) {
        println("${amount % lottoCost}" + printBuyMessage)
    }

    fun printWallet(wallet: MutableList<Int>) {
        println(wallet)
    }

    fun printRanking(rank: MutableList<Int>) {
        println(printRankMessage)
        for (idx in rank.indices) {
            when (idx) {
                0 -> println(firstRewardMessage + rank[idx] + count)
                1 -> println(secondRewardMessage + rank[idx] + count)
                2 -> println(thirdRewardMessage + rank[idx] + count)
                3 -> println(fourthRewardMessage + rank[idx] + count)
                4 -> println(fifthRewardMessage + rank[idx] + count)
            }
        }
    }

}