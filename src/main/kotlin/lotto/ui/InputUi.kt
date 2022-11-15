package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.*

class InputUi {
    private val printUi = PrintUi()
    fun inputMoney(): Int {
        printUi.pleaseInput("구입금액을")
        val money = Console.readLine()

        //숫자 및 천단위 입력만 가능
        money.inputTypeException()
        money.inputUnitException()

        return money.toInt()
    }

    fun inputWinningNumbers():List<Int>{
        printUi.pleaseInput("당첨 번호를")
        val input = Console.readLine()
        input.inputCommaException()
        val winningNumbers = Lotto(input.split(",").map(String::toInt))
        return winningNumbers.getNumbers()
    }

    fun inputBonusNumber():Int{
        printUi.pleaseInput("보너스 번호를")
        val bonus = Console.readLine().toInt()
        bonus.inputRangeException()
        return bonus
    }


}
