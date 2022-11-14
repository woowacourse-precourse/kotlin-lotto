package lotto

import Util.Game

class LottoPrinter {
    fun printLotto(lotto: List<List<Int>>) {
        println(Game.NUMBER_OF_LOTTO_OUTPUT.message.format(lotto.size))
        for (i in lotto.indices) {
            println(lotto[i])
        }
    }
}