package lotto

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

class UI {
    private val decFormat = DecimalFormat("###,###,###.0")

    /**
     * Functions named get[]()
     *
     * @return [] in string from user input
     */
    fun getMoney(): String { //-1 : error
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
    fun getLotteryNumber(): List<String> {
        println("당첨 번호를 입력해 주세요.")

        val lotteryNumber = Console.readLine()
        return lotteryNumber.split(",").map { it.trim() }
    }
    fun getBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }

    /**
     * @brief Print lotteryList
     * @param lotteryList: List of lotto instances
     */
    fun printLottery(lotteryList: List<Lotto>) {
        println("${lotteryList.size}개를 구매했습니다.")
        for(lottery in lotteryList) {
            println(lottery.lottoToString())
        }
    }
    /**
     * @brief Print statistics
     * @param winnings : map of (prize, the number of lotto won that prize)
     * @param earningsRate : rate of return
     */
    fun printStatistics(winnings: Map<Prize,Int>, earningsRate: Double) {
        println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - ${if(winnings[Prize.FIFTH]==null) 0 else winnings[Prize.FIFTH]}개\n" +
                "4개 일치 (50,000원) - ${if(winnings[Prize.FOURTH]==null) 0 else winnings[Prize.FOURTH]}개\n" +
                "5개 일치 (1,500,000원) - ${if(winnings[Prize.THIRD]==null) 0 else winnings[Prize.THIRD]}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${if(winnings[Prize.SECOND]==null) 0 else winnings[Prize.SECOND]}개\n" +
                "6개 일치 (2,000,000,000원) - ${if(winnings[Prize.FIRST]==null) 0 else winnings[Prize.FIRST]}개\n" +
                "총 수익률은 ${decFormat.format(earningsRate)}%입니다.")
    }
}