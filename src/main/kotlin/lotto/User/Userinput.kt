package lotto.User

import camp.nextstep.edu.missionutils.Console
import lotto.Contants.ErrorMessage

class UserInput {
    fun buyPrice() : Int {
        var input = Console.readLine()
        val buyPrice = input!!.toInt()
        print(buyPrice)

        if (buyPrice%1000 != 0 ){
            throw IllegalArgumentException("${ErrorMessage.ERROR1.messages}")
        }

        return buyPrice
    }

//    fun answerNumbers(){
//        var input = Console.readLine()
//        val buyPrice = input!!.map {
//            it.toString().split(',') }
//        print(answerNumbers())
//    }

}