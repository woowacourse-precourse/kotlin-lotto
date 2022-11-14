package lotto.view

import lotto.Lotto

object OutputView {
    fun printMyLottoInfo(lottos: List<Lotto>) {
        println()
        println("${lottos.size}개를 구매했습니다.")
        lottos.onEach { lotto -> println(lotto.sort().toString()) }
    }

    fun printWinningResult(){
        TODO()
    }

    fun printYield(){
        TODO()
    }
}