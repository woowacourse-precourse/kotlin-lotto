package lotto

import utils.Constants.PURCHASE_COUNT_MESSAGE
import utils.Constants.REQUIRE_INPUT_BONUS_MESSAGE
import utils.Constants.REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE
import utils.Constants.REQUIRE_WINNING_NUMBER_MESSAGE

class Display {

    fun printRequirePurchaseAmount() {
        println(REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLottoCount(count: Int) {
        println()
        println("${count}$PURCHASE_COUNT_MESSAGE")
    }
    fun printLottos(lottos: List<Lotto>) {
        for(lotto in lottos) {
            val numbers = lotto.getNumbers()
            print("[")
            for(i in 0 until numbers.size - 1) {
                print("${numbers[i]}, ")
            }
            println("${numbers.last()}]")
        }
    }

    fun printRequireWinningNumbers() {
        println()
        println(REQUIRE_WINNING_NUMBER_MESSAGE)
    }
    fun printRequireBonusNumber() {
        println()
        println(REQUIRE_INPUT_BONUS_MESSAGE)
    }

    fun printStatistics(matchingCounts: List<Int>, profit: Double) {
        val contents = MatchingContent.values()

        println()
        println("---")
        for(i in matchingCounts.indices) {
            println(contents[i].content + matchingCounts[i] + "개")
        }

        println("총 수익률은 ${profit}입니다.")
    }
}

enum class MatchingContent(val content: String) {
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - ");


}