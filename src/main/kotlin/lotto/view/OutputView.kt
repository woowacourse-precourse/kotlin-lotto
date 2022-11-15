package lotto.view

import lotto.Lotto
import kotlin.math.*

object OutputView {
    fun printMyLottoInfo(lottos: List<Lotto>) {
        println()
        println("${lottos.size}개를 구매했습니다.")
        lottos.onEach { lotto -> println(lotto.sort()) }
    }

    fun printWinningResult(results : List<Int>){
        println()
        println("당첨 통계\n---")
        println("3개 일치 (5,000원) - ${results[0]}개")
        println("4개 일치 (50,000원) - ${results[1]}개")
        println("5개 일치 (1,500,000원) - ${results[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${results[3]}개")
        println("6개 일치 (2,000,000,000원) - ${results[4]}개")
    }

    fun printYield(cost : Int, profit : Int ){
        (cost.toFloat() / profit.toFloat()) * 100
    }
}