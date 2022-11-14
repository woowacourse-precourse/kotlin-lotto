package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    val validator = Validator()


    fun getInputMoney() : Int {
        return inputMoney().toInt()
    }

    fun inputMoney() : String {
        println("구입금액을 입력해 주세요.")
        return checkInputMoney(Console.readLine())
    }
    fun checkInputMoney(input : String) : String{
        try {
            validator.checkMoneyInput(input)
            return input
        } catch (e : IllegalArgumentException) {
            e.printStackTrace()
            throw NoSuchElementException()
        }
    }
}