package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Win.*
import lotto.exception.validateUserInputBonusNumber
import lotto.exception.validateUserInputPurchasingAmount
import lotto.exception.validateUserInputWinNumbers

class UI {

    fun inputPurchasingAmount(): Long {
        val purchasingAmount = Console.readLine()
        validateUserInputPurchasingAmount(purchasingAmount)
        return purchasingAmount.toLong()
    }

    fun inputWinNumbers(): List<Int> {
        val winNumbers = Console.readLine()
        validateUserInputWinNumbers(winNumbers)
        return winNumbers.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        validateUserInputBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

    fun printBlankLine() {
        println()
    }

    fun printRequestPurchasingAmount() {
        println(REQUEST_INPUT_PURCHASING_AMOUNT)
    }

    fun printTheNumberOfLotto(theNumberOfLottos: Long) {
        println(PURCHASING_LOTTO.format(theNumberOfLottos))
    }

    fun printLottos(lottos: List<List<Int>>) {
        for (lotto in lottos) {
            println(lotto)
        }
    }

    fun printRequestWinNumbers() {
        println(REQUEST_INPUT_WIN_NUMBERS)
    }

    fun printRequestBonusNumber() {
        println(REQUEST_INPUT_BONUS_NUMBER)
    }

    fun printTotalWinStatistic(winStatistics: Map<Win, Int>) {
        val totalWinList = TOTAL_WIN_STATISTIC.format(
            winStatistics[FIFTH_PLACE],
            winStatistics[FOURTH_PLACE],
            winStatistics[THIRD_PLACE],
            winStatistics[SECOND_PLACE],
            winStatistics[FIRST_PLACE]
        )
        println(totalWinList)
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        val formattedRateOfReturn = RATE_OF_RETURN.format(rateOfReturn)
        println(formattedRateOfReturn)
    }

    companion object {
        const val REQUEST_INPUT_PURCHASING_AMOUNT = "구입금액을 입력해 주세요."
        const val PURCHASING_LOTTO = "%d개를 구매했습니다."
        const val REQUEST_INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요."
        const val REQUEST_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        const val TOTAL_WIN_STATISTIC = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개"
        const val RATE_OF_RETURN = "총 수익률은 %.1f%%입니다."

    }
}