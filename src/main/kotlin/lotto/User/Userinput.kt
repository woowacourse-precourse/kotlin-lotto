package lotto.User

import camp.nextstep.edu.missionutils.Console
import lotto.utils.ErrorMessage

public var ticket = 0
public var answer: List<Int> = ArrayList()
public var bonus = 0

class UserInput {
    fun buyPrice(): Int {
        val input = Console.readLine()
        val buyPrice = input!!.toInt()

        if (buyPrice % 1000 != 0) {
            throw IllegalArgumentException(ErrorMessage.ERROR1.messages)
        }

        ticket = buyPrice / 1000

        return ticket
    }

    fun answerNumbers(){
        val input = Console.readLine()
        val answerSheet = input!!.split(',').map(String::toInt)
        answer = answerSheet
    }
    fun bonusNumber(){
        val input = Console.readLine()
        val bonusNumber = input.toInt()
        bonus = bonusNumber
    }

}