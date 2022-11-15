package lotto

import camp.nextstep.edu.missionutils.Console

class UI {
    /**
     * Returns string of money from user input
     */
    fun getMoney(): String { //-1 : error
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
}