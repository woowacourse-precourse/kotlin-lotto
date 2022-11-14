package lotto

class Message {


    companion object {
        const val INPUT_MONEY_MASSAGE = "구입금액을 입력해 주세요."
        const val COUNT_MASSAGE = "개를 구매했습니다."
        const val INPUT_WINNING_MASSAGE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_MASSAGE = "보너스 번호를 입력해 주세요."
        const val STATISTICS_MASSAGE = "당첨 통계\n" + "---\n"
        const val UNIT_ERROR = "[ERROR] 1000 단위로 입력해야 합니다."
        const val MIN_VALUE_ERROR = "[ERROR] 로또 가격 이상 입력해야 합니다."
        const val SIZE_ERROR = "[ERROR] 사이즈는 6 이여야 합니다."
        const val SAME_WINNING_NUMBER_ERROR = "[ERROR] 당첨번호와 다른 숫자를 입력해야 합니다."
        const val SAME_DIGIT_ERROR = "[ERROR] 서로 다른 숫자를 입력해야 합니다."
        const val RANGE_ERROR = "[ERROR] 1 ~ 45사이 숫자를 입력해야 합니다."
        const val NOT_DIGIT_ERROR = "[ERROR] 숫자를 입력해야 합니다."
    }

    enum class WinGroup(val message: List<String>) {
        FifthPlace(listOf("3", "", "5,000")),
        FourthPlace(listOf("4", "", "50,000")),
        ThirdPlace(listOf("5", "", "1,500,000")),
        SecondPlace(listOf("5", ", 보너스 볼 일치", "30,000,000")),
        FirstPlace(listOf("6", "", "2,000,000,000"))
    }

    fun printLottoList(lottoList: List<String>) {
        println("${lottoList.size}" + COUNT_MASSAGE)
        lottoList.forEach { println(it) }
    }

    fun printStatistics(winningResult: List<Int>) {
        print(STATISTICS_MASSAGE)
        WinGroup.values().forEachIndexed { index, it ->
            println("${it.message[0]}개 일치${it.message[1]} (${it.message[2]}원) - ${winningResult[index]}개")
        }
    }

    fun printProfit(profitRate: Double) {
        print("총 수익률은 ${profitRate}%입니다.")
    }
}
