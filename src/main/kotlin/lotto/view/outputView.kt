package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.domain.PrizeResult

class outputView {

    fun printLotteriesCount(lotteriesCount:Int){
        println("${lotteriesCount}${LOTTO_COUNT_OUTPUT_MESSAGE}")
    }

    fun printLotteriesNumbers(lotteries: List<Lotto>){
        lotteries.forEach{lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    companion object{
        const val LOTTO_COUNT_OUTPUT_MESSAGE = "개를 구매했습니다."
    }
}