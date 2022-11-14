package lotto.ui

import lotto.Lotto

object Output {

    fun printLotto(lotto: Lotto) {
        lotto.print()
    }

    fun printCount(number: Int) {
        println("\n${number}개를 구매했습니다.")
    }

    fun printResult(result: List<Int>) {
        println("\n당첨 통계")
        println("---")
        println(State.FIFTH.printResult(result[4]))
        println(State.FOURTH.printResult(result[3]))
        println(State.THIRD.printResult(result[2]))
        println(State.SECOND.printResult(result[1]))
        println(State.FIRST.printResult(result[0]))
    }

    fun printRatio(number: String) {
        println("총 수익률은 ${number}%입니다.")
    }
}

enum class State (val message: String) {
    FIRST("6개 일치 (2,000,000,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    FIFTH("3개 일치 (5,000원) - ");

    fun printResult(n: Int) = message+"${n}개"
}