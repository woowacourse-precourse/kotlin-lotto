package lotto

import utils.Constants.LOTTO_NUMBER
import utils.Constants.PROFIT_RESULT
import utils.Constants.PURCHASE_COUNT_MESSAGE
import utils.Constants.REQUIRE_INPUT_BONUS_MESSAGE
import utils.Constants.REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE
import utils.Constants.REQUIRE_WINNING_NUMBER_MESSAGE

class Display {

    fun printRequirePurchaseAmount() {
        println(REQUIRE_INPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLottoCount(purchaseAmount: Int) {
        val count = purchaseAmount / 1000

        println()
        println(PURCHASE_COUNT_MESSAGE.format(count))
    }
    
    // todo 여기 좀 쉽게 리팩터
    fun printLottos(lottos: List<Lotto>) {
        for(lotto in lottos) {
            val numbers = lotto.getNumbers()
            val formatting = formattingNumbers(numbers)
            println(LOTTO_NUMBER.format(formatting))
        }
    }

    private fun formattingNumbers(numbers: List<Int>): String {
        var formatting = ""
        for (number in numbers) {
            formatting = formatting.plus(number).plus(", ")
        }

        return formatting.substring(0, formatting.length - 2)
    }

    fun printRequireWinningNumbers() {
        println()
        println(REQUIRE_WINNING_NUMBER_MESSAGE)
    }
    fun printRequireBonusNumber() {
        println()
        println(REQUIRE_INPUT_BONUS_MESSAGE)
    }

    fun printStatistics(matchingResult: Pair<List<Int>, Double>) {
        val contents = MatchingContent.values()
        val matchingCounts = matchingResult.first
        val profit = matchingResult.second

        println()
        println("---")
        for(i in matchingCounts.indices) {
            println(contents[i].content.format(matchingCounts[i]))
        }
        println(PROFIT_RESULT.format(profit))
    }
}