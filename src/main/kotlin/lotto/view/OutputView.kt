package lotto.view

import lotto.domain.Lotto
import lotto.domain.PrizeResult

class OutputView {

    fun printLotteriesCount(lotteriesCount:Int){
        println("${lotteriesCount}${LOTTO_COUNT_OUTPUT_MESSAGE}")
    }

    fun printLotteriesNumbers(lotteries: List<Lotto>){
        lotteries.forEach{lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printLottoPrizeResult(prizeResult: PrizeResult){
        println(LOTTO_RESULT_INTRO_OUTPUT_MESSAGE)
        println("$FIFTH_PLACE_OUTPUT_MESSAGE ${prizeResult.fifthPlace}개")
        println("$FOURTH_PLACE_OUTPUT_MESSAGE ${prizeResult.fourthPlace}개")
        println("$THIRD_PLACE_OUTPUT_MESSAGE ${prizeResult.thirdPlace}개")
        println("$SECOND_PLACE_OUTPUT_MESSAGE ${prizeResult.secondPlace}개")
        println("$FIRST_PLACE_OUTPUT_MESSAGE ${prizeResult.firstPlace}개")
    }

    fun printProfitPercentage(profitPercentage:Double){
        println("$PROFIT_PERCENTAGE_OUTPUT_MESSAGE ${profitPercentage}%입니다.")
    }

    companion object{
        const val LOTTO_COUNT_OUTPUT_MESSAGE = "개를 구매했습니다."
        const val LOTTO_RESULT_INTRO_OUTPUT_MESSAGE = "당첨 통계\n---"
        const val FIFTH_PLACE_OUTPUT_MESSAGE = "3개 일치 (5,000원) -"
        const val FOURTH_PLACE_OUTPUT_MESSAGE = "4개 일치 (50,000원) -"
        const val THIRD_PLACE_OUTPUT_MESSAGE = "5개 일치 (1,500,000원) -"
        const val SECOND_PLACE_OUTPUT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) -"
        const val FIRST_PLACE_OUTPUT_MESSAGE = "6개 일치 (2,000,000,000원) -"
        const val PROFIT_PERCENTAGE_OUTPUT_MESSAGE = "총 수익률은"
    }
}