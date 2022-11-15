package lotto.User

import camp.nextstep.edu.missionutils.Console
import lotto.utils.ErrorCheck
import lotto.utils.ErrorMessage

public var ticket = 0
public var answer: List<Int> = ArrayList()
public var bonus = 0

class UserInput {
    fun buyPrice(): Int {
        var input = Console.readLine()
        ErrorCheck().errorString(input)


        val buyPrice = input!!.toInt()
        ErrorCheck().errorPrice(buyPrice)

        ticket = buyPrice / 1000

        return ticket
    }

    fun answerNumbers() {
        val input = Console.readLine()
        val answerSheet = input!!.split(',').map(String::toInt)
        answer = answerSheet.sorted()
        ErrorCheck().duplicatedNumber(answer)
        ErrorCheck().ListnumberRange(answer)
    }

    fun bonusNumber() {
        val input = Console.readLine()
        val bonusNumber = input.toInt()
        bonus = bonusNumber
        ErrorCheck().NumberRange(bonus)
        ErrorCheck().isNotIncludedNumbers(bonus, answer)
    }

}