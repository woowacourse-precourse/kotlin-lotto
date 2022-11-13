package lotto.views

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }
}