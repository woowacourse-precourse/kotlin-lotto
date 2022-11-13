package lotto

import camp.nextstep.edu.missionutils.Console
import exception.LottoBonus
import exception.LottoPurchase
import exception.LottoWinning

class Lotto(private var numbers: List<Int>) {
    private val viewModel = LottoViewModel()
    var purchaseAmount = ""
    var winningNumber = ""
    var bonusNumber = 0

    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().count())
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
        purchaseAmount = Console.readLine()

        LottoPurchase(purchaseAmount)

        println()
    }

    private fun printIssuedNumber() {
        val numberOfPurchase = viewModel.div(purchaseAmount)

        println("${numberOfPurchase}개를 구매했습니다.")

        for (i in 0 until numberOfPurchase) {
            viewModel.issuedNumbers[i] = numbers.sorted().toMutableList()
            println(viewModel.issuedNumbers[i])
            numbers = viewModel.pickRandomNumber()
        }

        println()
    }

    private fun enterWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
        winningNumber = Console.readLine()

        LottoWinning(winningNumber)

        println()
    }

    private fun enterBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        bonusNumber = Console.readLine().toInt()

        LottoBonus(bonusNumber)

        println()
    }

    private fun printWinningStatistics() {
        println("당첨 통계")
        println("---")

        viewModel.compareNumbers(purchaseAmount, winningNumber, bonusNumber)

        printWinningHistory()
        println("총 수익률은 ${viewModel.getProfit(purchaseAmount)}%입니다.")
    }

    private fun printWinningHistory() {
        println(
            "3개 일치 (5,000원) - ${Winning.THREE.getNumberOfMatches()}개\n" +
                    "4개 일치 (50,000원) - ${Winning.FOUR.getNumberOfMatches()}개\n" +
                    "5개 일치 (1,500,000원) - ${Winning.FIVE.getNumberOfMatches()}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${Winning.FIVEWITHBONUS.getNumberOfMatches()}개\n" +
                    "6개 일치 (2,000,000,000원) - ${Winning.SIX.getNumberOfMatches()}개"
        )
    }
}
