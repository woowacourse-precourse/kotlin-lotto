package lotto.ui

import lotto.Lotto

object Output {

    fun printLotto(lotto: Lotto) {
        lotto.print()
    }

    fun printCount(number: Int) {
        println("\n${number}개를 구매했습니다.")
    }

}