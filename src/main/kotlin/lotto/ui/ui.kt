package lotto.ui

import camp.nextstep.edu.missionutils.Console

class ui {
     fun moneyInput() : Int {
        println("구입금액을 입력해 주세요.")
        var money = Console.readLine().toInt()
        return money
    }

}
