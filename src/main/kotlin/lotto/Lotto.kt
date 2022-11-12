package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

class Lotto(private var numbers: List<Int>) {
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
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
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
        when (matchedWinningNumbers.size) {
            3 -> { Winning.THREE.addAmountAndNumberOfMatches() }
            4 -> { Winning.FOUR.addAmountAndNumberOfMatches() }
            5 -> {
                if (matchedBonusNumbers.size != 1) {
                    Winning.FIVE.addAmountAndNumberOfMatches()
                } else {
                    Winning.FIVEWITHBONUS.addAmountAndNumberOfMatches()
                }
            }
            6 -> { Winning.SIX.addAmountAndNumberOfMatches() }
        }

        println(
            "3개 일치 (5,000원) - ${Winning.THREE.getNumberOfMatches()}개\n" +
                    "4개 일치 (50,000원) - ${Winning.FOUR.getNumberOfMatches()}개\n" +
                    "5개 일치 (1,500,000원) - ${Winning.FIVE.getNumberOfMatches()}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${Winning.FIVEWITHBONUS.getNumberOfMatches()}개\n" +
                    "6개 일치 (2,000,000,000원) - ${Winning.SIX.getNumberOfMatches()}개"
        )
    }

    private fun printProfitRate() {
        val winningAmount =
            Winning.THREE.getAmount() + Winning.FOUR.getAmount() + Winning.FIVE.getAmount() + Winning.FIVEWITHBONUS.getAmount() + Winning.SIX.getAmount()
        val profit = (winningAmount.toDouble() / purchaseAmount.toDouble()) * 100

        println("총 수익률은 ${round(profit * 10) / 10}%입니다.")
    }
}
