package lotto

private const val ENTER_PURCHASE_MOENY = "구입금액을 입력해 주세요."
private const val PURCHASE_HOW_MANY = "개를 구매했습니다."
private const val ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
private const val ENTER_BONUS_NUMBERS = "보너스 번호를 입력해 주세요."
private const val WIN_STATISTICS = "당첨 통계"
private const val BORDER = "---"
private const val TOTAL_EARNING_RATE = "총 수익률은 "
private const val PERCENT = "%입니다."

class Printer {
    fun printEnterMoneyRequest() {
        println(ENTER_PURCHASE_MOENY)
    }

    fun printNumberOfPurchaseLottos(numberOfLottos: Int) {
        println()
        println(numberOfLottos.toString() + PURCHASE_HOW_MANY)
    }

    fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { it.printNumbers() }
    }

    fun printEnterWinningNumbers() {
        println()
        println(ENTER_WINNING_NUMBERS)
    }

    fun printEnterBonusNumber() {
        println()
        println(ENTER_BONUS_NUMBERS)
    }

    fun printWinStatistics() {
        println()
        println(WIN_STATISTICS)
        println(BORDER)
    }

    fun printLottoResult(result: Map<MatchedCount, Int>) {
        result.forEach { (matchedCount, count) ->
            matchedCount.printLottoResult(count)
        }
    }

    fun printEarningRate(earningRate: String) {
        println("$TOTAL_EARNING_RATE$earningRate$PERCENT")
    }
}
