package lotto

import camp.nextstep.edu.missionutils.Randoms

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

fun main() {
    TODO("프로그램 구현")
}
