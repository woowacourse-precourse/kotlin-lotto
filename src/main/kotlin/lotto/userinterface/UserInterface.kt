package lotto.userinterface

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Rank
import lotto.service.dto.LottoDto
import lotto.service.dto.WinningStatisticsDto
import java.math.BigInteger
import java.text.DecimalFormat


object UserInterface {

    private const val PURCHASE_AMOUNT_LIMIT = 2_000_000_000
    private val decimalFormat = DecimalFormat("#,###")

    fun askPurchaseAmount(): Int {
        println(REQUEST_PURCHASE_AMOUNT)
        val readValue = Console.readLine()
        validatePurchaseAmount(readValue)
        return readValue.toInt()
    }

    private fun validatePurchaseAmount(readValue: String) {
        validatePurchaseAmountType(readValue)
        validatePurchaseAmountLimit(readValue)
        validatePurchaseAmountDivisible(readValue)
    }

    private fun validatePurchaseAmountType(readValue: String) =
        require(readValue.all { it.isDigit() }) { PURCHASE_AMOUNT_MUST_BE_A_NUMBER }

    private fun validatePurchaseAmountLimit(readValue: String) {
        val purchaseAmount = BigInteger(readValue)
        require(purchaseAmount <= BigInteger(PURCHASE_AMOUNT_LIMIT.toString())) {
            String.format(
                PURCHASE_AMOUNT_MUST_NOT_EXCEED_LIMIT, decimalFormat.format(PURCHASE_AMOUNT_LIMIT)
            )
        }
    }

    private fun validatePurchaseAmountDivisible(readValue: String) {
        val purchaseAmount = BigInteger(readValue)
        require(
            purchaseAmount.mod(BigInteger("1000")).equals(BigInteger.ZERO)
        ) { PURCHASE_AMOUNT_MUST_BE_DIVIDED_BY_1000 }
    }


    fun showPurchaseResult(lotteries: List<LottoDto>) {
        println(String.format(PURCHASE_RESULT, lotteries.size))
        lotteries.forEach { println(it.numbers) }
    }

    fun askWinningNumbers(): List<Int> {
        println(REQUEST_WINNING_NUMBERS)
        val readValue = Console.readLine()
        validateWinningNumbers(readValue)
        return readValue.split(",").map { it.trim() }.map { it.toInt() }
    }

    private fun validateWinningNumbers(readValue: String) {
        validateWinningNumbersSize(readValue)
        validateWinningNumbersRange(readValue)
        validateWinningNumbersDuplicated(readValue)
    }

    private fun validateWinningNumbersSize(readValue: String) =
        require(readValue.split(",").size == 6) { WINNING_NUMBERS_SIZE_MUST_BE_6 }

    private fun validateWinningNumbersRange(readValue: String) {
        val splitValues = readValue.split(",").map { it.trim() }
        require(splitValues.all { it.matches(Regex("\\d{1,2}")) && it.toInt() in 1..45 }) { WINNING_NUMBERS_MUST_BE_BETWEEN_1_AND_45 }
    }

    private fun validateWinningNumbersDuplicated(readValue: String) {
        val splitValues = readValue.split(",").map { it.trim() }
        require(splitValues.toSet().size == splitValues.size) { WINNING_NUMBERS_MUST_NOT_BE_DUPLICATED }
    }

    fun askBonusNumberNotIn(winningNumbers: List<Int>): Int {
        println(REQUEST_BONUS_NUMBER)
        val readValue = Console.readLine()
        validateBonusNumber(readValue, winningNumbers)
        return readValue.toInt()
    }

    private fun validateBonusNumber(readValue: String, winningNumbers: List<Int>) {
        validateBonusNumberRange(readValue)
        validateBonusNumberThatIsIncludedInWinningNumbers(readValue, winningNumbers)
    }

    private fun validateBonusNumberRange(readValue: String) =
        require(readValue.matches(Regex("\\d{1,2}")) && readValue.toInt() in 1..45) { BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45 }

    private fun validateBonusNumberThatIsIncludedInWinningNumbers(readValue: String, winningNumbers: List<Int>) =
        require(readValue.toInt() !in winningNumbers) { BONUS_NUMBER_MUST_NOT_BE_INCLUDED_IN_WINNING_NUMBERS }

    fun showWinningStatistics(winningStatistics: WinningStatisticsDto) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (${decimalFormat.format(Rank.FIFTH.winnings)}원) - ${winningStatistics.winningCount(Rank.FIFTH)}개")
        println("4개 일치 (${decimalFormat.format(Rank.FOURTH.winnings)}원) - ${winningStatistics.winningCount(Rank.FOURTH)}개")
        println("5개 일치 (${decimalFormat.format(Rank.THIRD.winnings)}원) - ${winningStatistics.winningCount(Rank.THIRD)}개")
        println("5개 일치, 보너스 볼 일치 (${decimalFormat.format(Rank.SECOND.winnings)}원) - ${winningStatistics.winningCount(Rank.SECOND)}개")
        println("6개 일치 (${decimalFormat.format(Rank.FIRST.winnings)}원) - ${winningStatistics.winningCount(Rank.FIRST)}개")
        println("총 수익률은 ${winningStatistics.yields}%입니다.")
    }
}