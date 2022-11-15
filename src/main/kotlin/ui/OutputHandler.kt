package ui

import lotto.LottoCalculation
import values.*

class OutputHandler {

    fun totalStatus(lottoList: List<List<Int>>, jackpot: List<Int>, bonus: Int, price: Int) {
        val calc = LottoCalculation()
        val countJackpot: List<Int> = calc.countJackpot(lottoList, jackpot, bonus)
        val prize: Long = calc.calculatePrize(countJackpot)
        val rateOfReturn: Double = calc.rateOfReturn(price, prize)

        println()
        println(PRINT_MESSAGE_TOTAL_JACKPOT)
        println(DIVIDE_LINE)

        println("3개 일치 (5,000원) - ${countJackpot[INDEX_THREE_COINCIDENCE]}개")
        println("4개 일치 (50,000원) - ${countJackpot[INDEX_FOUR_COINCIDENCE]}개")
        println("5개 일치 (1,500,000원) - ${countJackpot[INDEX_FIVE_COINCIDENCE]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${countJackpot[INDEX_FIVE_AND_BONUS_COINCIDENCE]}개")
        println("6개 일치 (2,000,000,000원) - ${countJackpot[INDEX_SIX_COINCIDENCE]}개")

        println("총 수익률은 ${rateOfReturn}%입니다.")
    }

    fun lottoStatus(lottoList: List<List<Int>>) {
        println()
        println(PRINT_MESSAGE_PURCHASES_NUMBER)
        lottoList.forEach { println(it) }
    }
}