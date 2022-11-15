package lotto.view

import lotto.domain.Calculator
import lotto.domain.NumberGenerator
import lotto.domain.Ranking
import lotto.utils.*

class OutputView {
    // 발행한 로또 수량 및 번호를 출력한다. (로또 번호는 오름차순 정렬)
    fun printLottoNumbers(tryNumber: Int): List<List<Int>> {
        println("\n${tryNumber}개를 구매했습니다.")
        val generator = NumberGenerator()
        val lottoNumbers = mutableListOf<List<Int>>()
        for (i in 0 until tryNumber) {
            val lottoNumber = generator.createLottoNumbers()
            lottoNumbers.add(lottoNumber)
            println(lottoNumber)
        }
        return lottoNumbers
    }

    // 당첨 내역을 출력한다.
    fun printWinnerList(winners: List<Int>) {
        println(WINNER_RESULT_MGS)
        println("$WINNER_5_MSG - ${winners[Ranking.FIFTH.ordinal]}개")
        println("$WINNER_4_MSG - ${winners[Ranking.FOURTH.ordinal]}개")
        println("$WINNER_3_MSG - ${winners[Ranking.THIRD.ordinal]}개")
        println("$WINNER_2_MSG - ${winners[Ranking.SECOND.ordinal]}개")
        println("$WINNER_1_MSG - ${winners[Ranking.FIRST.ordinal]}개")
    }

    // 수익률을 출력한다.
    fun printEarningRate(winners: List<Int>, paidAmount: Int) {
        val calculator = Calculator()
        val profits = calculator.calcProfits(winners)
        val earningRate = calculator.calcEarningRate(profits, paidAmount)
        println("총 수익률은 ${earningRate}%입니다.")
    }
}