package lotto.ui

import camp.nextstep.edu.missionutils.Console

class InputUi {
    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }

    fun inputWinningNumbers():List<Int>{
        return Console.readLine().split(",").map(String::toInt)
    }

    fun inputBonusNumber():Int{
        return Console.readLine().toInt()
    }
}