package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.inputTypeException
import lotto.inputUnitException

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
        val winningNumbers =  Console.readLine().split(",").map(String::toInt)
        for(index in winningNumbers.indices){
            if(winningNumbers[index] !in 1..45){
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
            if(winningNumbers.size!=winningNumbers.toSet().size){
                throw IllegalArgumentException("[ERROR] 로또 번호는 중복되자 않아야 합니다.")
            }
        }
        return winningNumbers
    }

    fun inputBonusNumber():Int{
        printUi.pleaseInput("보너스 번호를")
        val bonus = Console.readLine().toInt()
        if (bonus !in 1..45){
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return bonus
    }


}
