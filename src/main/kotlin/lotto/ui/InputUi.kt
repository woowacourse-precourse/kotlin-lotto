package lotto.ui

import camp.nextstep.edu.missionutils.Console

class InputUi {
    private val printUi = PrintUi()
    fun inputMoney(): Int {
        printUi.pleaseInput("구입금액을")
        return Console.readLine().toInt()
    }

    fun inputWinningNumbers():List<Int>{
        printUi.pleaseInput("당첨 번호를")
        return Console.readLine().split(",").map(String::toInt)
    }

    fun inputBonusNumber():Int{
        printUi.pleaseInput("보너스 번호를")
        return Console.readLine().toInt()
    }
}