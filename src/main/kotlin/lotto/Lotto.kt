package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LotteryConverter
import java.text.DecimalFormat

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}

class AutomaticLotteryTickets(private val purchaseAmount: Int) : Iterable<List<Int>> {
    private val tickets = arrayListOf<List<Int>>()
    private var index = 0

    init {
        require(purchaseAmount % 1000 == 0 && purchaseAmount > 0) { "[ERROR] 구입 금액이 1000원 단위가 아님" }
        for (i in 0 until purchaseAmount / 1000)
            tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    fun countTickets(): Int {
        return tickets.count()
    }

    override fun toString(): String {
        return tickets.toString()
    }

    override fun iterator(): Iterator<List<Int>> {
        return object : Iterator<List<Int>> {
            var index = 0

            override fun next(): List<Int> {
                return tickets[index++]
            }

            override fun hasNext(): Boolean {
                return index < tickets.count()
            }
        }
    }

}


class LottoWinningStat(
    private val lotto: Lotto,
    private val bonusNumber: Int,
    private val tickets: AutomaticLotteryTickets
) {
    private var winningStat = mutableMapOf(
        LotteryRank.ONE to 0,
        LotteryRank.TWO to 0,
        LotteryRank.THREE to 0,
        LotteryRank.FOUR to 0,
        LotteryRank.FIVE to 0
    )  // 각각의 등수가 몇 개 존재하는지를 나타낸다.

    private var totalEarningRate: Float = 0f

    init {
        require(!lotto.contains(bonusNumber)) { "[ERROR] 보너스 번호가 당첨 번호와 중복됨" }
        updateWinningStat()
        updateTotalEarningRate()
    }

    override fun toString(): String {
        val df = DecimalFormat("#,###")

        return """
            3개 일치 (${df.format(LotteryConverter.PRICE5)}원) - ${winningStat[LotteryRank.FIVE]}개
            4개 일치 (${df.format(LotteryConverter.PRICE4)}원) - ${winningStat[LotteryRank.FOUR]}개
            5개 일치 (${df.format(LotteryConverter.PRICE3)}원) - ${winningStat[LotteryRank.THREE]}개
            5개 일치, 보너스 볼 일치 (${df.format(LotteryConverter.PRICE2)}원) - ${winningStat[LotteryRank.TWO]}개
            6개 일치 (${df.format(LotteryConverter.PRICE1)}원) - ${winningStat[LotteryRank.ONE]}개
            총 수익률은 ${String.format("%.1f", totalEarningRate)}%입니다.
        """.trimIndent()
    }

    private fun updateWinningStat() {
        for (ticket in this.tickets) {
            val matchedNumberCount = checkHowManyMatches(ticket)
            var bonusCount = 0
            if (matchedNumberCount == 5 && checkBonusMatch())
                bonusCount = 1

            if(matchedNumberCount >= 3) {
                val rank = LotteryConverter.getRankByCount(matchedNumberCount, bonusCount)
                winningStat[rank] = winningStat[rank]!! + 1
            }
        }
    }

    private fun updateTotalEarningRate() {
        totalEarningRate =
            ((LotteryConverter.PRICE1 * winningStat[LotteryRank.ONE]!! +
                    LotteryConverter.PRICE2 * winningStat[LotteryRank.TWO]!! +
                    LotteryConverter.PRICE3 * winningStat[LotteryRank.THREE]!! +
                    LotteryConverter.PRICE4 * winningStat[LotteryRank.FOUR]!! +
                    LotteryConverter.PRICE5 * winningStat[LotteryRank.FIVE]!!).toFloat() /
                    (tickets.countTickets() * 1000)) * 100
    }

    private fun checkHowManyMatches(ticket: List<Int>): Int {
        var result = 0
        for (number in ticket) if (lotto.contains(number)) result++

        return result
    }

    private fun checkBonusMatch(): Boolean {
        return lotto.contains(bonusNumber)
    }
}

enum class LotteryRank {
    ONE, TWO, THREE, FOUR, FIVE
}

object LotteryConverter {
    const val PRICE1 = 2000000000
    const val PRICE2 = 30000000
    const val PRICE3 = 1500000
    const val PRICE4 = 50000
    const val PRICE5 = 5000

    fun getPriceByRank(lotteryRank: LotteryRank): Int {
        return rankToPrice[lotteryRank]!!
    }

    fun getRankByCount(matchedLottoNumber: Int, matchedBonusNumber: Int = 0): LotteryRank {
        require(matchedLottoNumber + matchedBonusNumber <= 6 && matchedBonusNumber <= 1) { "[ERROR] LotteryConverter.getRankByCount: 잘못된 파라미터가 전달 되었음" }

        val key = matchedLottoNumber.toFloat() + matchedBonusNumber.toFloat() * 0.5f

        return countToRank[key]!!
    }

    private val rankToPrice = mapOf(
        LotteryRank.ONE to PRICE1,
        LotteryRank.TWO to PRICE2,
        LotteryRank.THREE to PRICE3,
        LotteryRank.FOUR to PRICE4,
        LotteryRank.FIVE to PRICE5,
    )
    private val countToRank = mapOf(
        6f to LotteryRank.ONE,
        5.5f to LotteryRank.TWO,
        5f to LotteryRank.THREE,
        4f to LotteryRank.FOUR,
        3f to LotteryRank.FIVE
    )
}