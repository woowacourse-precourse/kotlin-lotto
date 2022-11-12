package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.math.round

class Lotto(private val numbers: List<Int>) {
    private val inputVerifier = InputVerifier()
    private var issuedNumbers = mutableMapOf<Int, MutableList<Int>>()
    private var purchaseAmount = 0
    private var numberOfPurchase = 0
    private var winningNumber = ""
    private var bonusNumber = 0
    private var winningAmount = 0
    private var matchedWinningNumbers = listOf<Int>()
    private var matchedBonusNumbers = listOf<Int>()

    init {
        require(numbers.size == 6)
    }

    fun startGame() {
        enterPurchaseAmount()
        printIssuedNumber()
        enterWinningNumber()
        enterBonusNumber()
        printWinningStatistics()
    }

    private fun enterPurchaseAmount() {
        println("구입금액을 입력해 주세요.")
        purchaseAmount = Console.readLine().toInt()

        inputVerifier.validatePurchaseAmount(purchaseAmount)
    }

    private fun printIssuedNumber() {
        numberOfPurchase = purchaseAmount.div(1000)

        println("${numberOfPurchase}개를 구매했습니다.")

        for (i in 0 until numberOfPurchase) {
            issuedNumbers[i] = numbers.sorted().toMutableList()
            println(issuedNumbers[i])
        }
    }

    private fun enterWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
        winningNumber = Console.readLine()

        inputVerifier.validateWinningNumber(winningNumber)
    }

    private fun enterBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        bonusNumber = Console.readLine().toInt()

        inputVerifier.validateBonusNumber(bonusNumber)
    }

    private fun printWinningStatistics() {
        println("당첨 통계")
        println("---")

        val winningNumberList = winningNumber.split(",").toList().map { it.toInt() }

        for (i in 0 until numberOfPurchase) {
            val unionOfWinning = listOf(winningNumberList, issuedNumbers[i]).flatMap { it.orEmpty() }
            matchedWinningNumbers = matchedNumbers(unionOfWinning)

            issuedNumbers[i]?.add(bonusNumber)
            matchedBonusNumbers = matchedNumbers(issuedNumbers[i]!!.toList())
        }

        printWinningHistory()
        printProfitRate()
    }

    private fun matchedNumbers(list: List<Int>): List<Int> {
        return list.groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()
    }

    private fun printWinningHistory() {
        val three = 0
        val four = 0
        val five = 0
        val fiveWithBonus = 0
        val six = 0

        when (matchedWinningNumbers.size) {
            3 -> { addAmountAndNumberOfMatches(5000, three) }
            4 -> { addAmountAndNumberOfMatches(50000, four) }
            5 -> {
                if (matchedBonusNumbers.size != 1) {
                    addAmountAndNumberOfMatches(1500000, five)
                } else {
                    addAmountAndNumberOfMatches(30000000, fiveWithBonus)
                }
            }
            6 -> { addAmountAndNumberOfMatches(2000000000, six) }
        }

        println(
            "3개 일치 (5,000원) - ${three}개\n" +
                    "4개 일치 (50,000원) - ${four}개\n" +
                    "5개 일치 (1,500,000원) - ${five}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${fiveWithBonus}개\n" +
                    "6개 일치 (2,000,000,000원) - ${six}개"
        )
    }

    private fun addAmountAndNumberOfMatches(money: Int, number: Int) {
        var numberOfMatches = number

        winningAmount += money
        numberOfMatches += 1
    }

    private fun printProfitRate() {
        val profit = (winningAmount.toDouble() / purchaseAmount.toDouble()) * 100

        println("총 수익률은 ${round(profit * 10) / 10}%입니다.")
    }
}
