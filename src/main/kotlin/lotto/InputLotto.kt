package lotto

import camp.nextstep.edu.missionutils.Console

class InputLotto() {

    //todo 로또 구매할 금액
    //todo 로또 몇장이 살 수 있는지 확인
    //todo 입력 값 에러 검사

    fun inputPrice() {
        val input = Console.readLine()

    }

    fun moneyToLotto(money: Int) = money / 1000

    private fun checkInputType(input: String) {
        try {
            input.toInt()
        } catch (e: Exception) {
            invalidInputValue(TYPE_ERROR)
        }
    }

    private fun checkAmount(amount: Int) {
        if (amount % 1000 != 0)
            invalidInputValue(VALUE_ERROR)
    }

    private fun invalidInputValue(message: String) {
        throw IllegalArgumentException("[ERROR] : $message")
    }

    companion object {
        const val TYPE_ERROR = "숫자가 아닙니다."
        const val VALUE_ERROR = "올바른 값이 아닙니다."
    }

}