package lotto

class Message {


    companion object {
        const val INPUT_MONEY_MASSAGE = "구입금액을 입력해 주세요."
        const val COUNT_MASSAGE = "개를 구매했습니다."
        const val INPUT_WINNING_MASSAGE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_MASSAGE = "보너스 번호를 입력해 주세요."
        const val ERROR_MASSAGE = "[ERROR]"
        const val STATISTICS_MASSAGE = "당첨 통계\n" + "---\n"
        const val SECOND_PLACE = 3
    }

    enum class WinGroup(val prize: String, val sameNumber: Int, val bonus: String, val winning: Int) {
        FifthPlace("5,000", 3, "", 0),
        FourthPlace("50,000", 4, "", 1),
        ThirdPlace("1,500,000", 5, "", 2),
        SecondPlace("30,000,000", 5, ", 보너스 볼 일치", 3),
        FirstPlace("2,000,000,000", 6, "", 4)
    }

    fun printTickets(lotteryTickets: List<String>) {
        println("${lotteryTickets.size}" + COUNT_MASSAGE)
        lotteryTickets.forEach { println(it) }
    }

    fun printStatistics(winningResult: List<Int>) {
        print(STATISTICS_MASSAGE)

        WinGroup.values().forEachIndexed { index, it ->
            println("${it.sameNumber}개 일치${it.bonus} (${it.prize}원) - ${winningResult[index]}개")
        }
    }

    fun printProfit(profitRate: Double) {
        print("총 수익률은 ${profitRate}%입니다.")
    }
}
