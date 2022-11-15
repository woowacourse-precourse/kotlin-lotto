package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

const val LOTTERY_PRICE = 1000
const val LOTTERY_SIZE = 6
const val TAG = "ERROR"
val NUMBER_RANGE = 1..45

/**
 * @param money : user money to purchase lotto
 * @return List of Lotto that user bought
 */
fun buyLottery(money: Int): List<Lotto> {
    val lotteryList = mutableListOf<Lotto>()
    val numOfLotteries = money / LOTTERY_PRICE
    for(i in 1..numOfLotteries) {
        lotteryList.add(Lotto(Randoms.pickUniqueNumbersInRange(NUMBER_RANGE.first, NUMBER_RANGE.last, 6)))
    }
    return lotteryList
}

/**
 * @param winnings : map of (prize, the number of lotto won that prize)
 * @param money : money spent on purchasing lotto
 * @return rate of return
 */
fun calculateEarnings(winnings: Map<Prize,Int>, money: Int): Double {
    var totalPrize = 0
    for(prize in winnings) {
        totalPrize += prize.key.earnings * prize.value
    }
    return round(totalPrize.toDouble()/money.toDouble()*1000) /10.0
}

/**
 * @brief Calculate how many lotteries user won
 * @param lotteryList : list of lotteries user bought
 * @param winningNumbers : list of winning numbers
 * @return map of (prize, the number of lotto won that prize)
 */
fun getWinnings(lotteryList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
    val winnings = mutableMapOf<Prize, Int>()
    for(lottery in lotteryList) {
        val prize = lottery.winLottery(winningNumbers, bonusNumber)
        if(winnings[prize] == null) winnings[prize] = 1
        else winnings[prize] = winnings[prize]!! + 1
    }
    return winnings
}

fun main() {
    TODO("프로그램 구현")
}
