package lotto.User

import camp.nextstep.edu.missionutils.Console
import lotto.utils.ErrorMessage

class UserInput {
    fun buyPrice() : Int {
        val input = Console.readLine()
        val buyPrice = input!!.toInt()

        if (buyPrice%1000 != 0 ){
            throw IllegalArgumentException("${ErrorMessage.ERROR1.messages}")
        }

        val ticket = buyPrice/1000

        return ticket
    }

//    fun answerNumbers(){
//        var input = Console.readLine()
//        val buyPrice = input!!.map {
//            it.toString().split(',') }
//        print(answerNumbers())
//    }

}