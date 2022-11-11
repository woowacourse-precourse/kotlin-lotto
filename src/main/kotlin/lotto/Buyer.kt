package lotto

import java.lang.IllegalArgumentException

class Buyer {
    fun enterAmount(): Int {
        val input = readln()
        checkIsBlank(input)
        checkIsNumber(input)
        checkIsInIntRange(input)
        return input.toInt()
    }

    private fun checkIsBlank(input: String){
        if(input.isBlank()) {
            Printer.printError("구입금액을 입력해주세요.")
            throw IllegalArgumentException("구입금액을 입력해주세요.")
        }
    }

    private fun checkIsNumber(input: String) {
        input.forEach {
            if(!it.isDigit()){
                Printer.printError("숫자를 입력해주세요.")
                throw IllegalArgumentException("숫자를 입력해주세요.")
            }
        }
    }

    private fun checkIsInIntRange(input: String) {
        if (input.toLong() > Int.MAX_VALUE) {
            Printer.printError("구매 가능 최대 금액은 2147483000원입니다.")
            throw IllegalArgumentException("구매 가능 최대 금액은 2147483000원입니다.")
        }
    }
}