package lotto

import camp.nextstep.edu.missionutils.Console

class LottoCustomer {
    fun customerLottoBuyPriceInput(): Int {
        println(LottoProcessStatement.INPUT_LOTTO_BUY_PRICE)
        val userInput = Console.readLine()
        return userInput.toInt()
    }
}