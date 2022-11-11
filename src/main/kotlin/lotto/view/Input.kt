package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney():Int{
        println("구입금액을 입력해 주세요.")
        val money = Console.readLine().toInt()
        return money
    }
}