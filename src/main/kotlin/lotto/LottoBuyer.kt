package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBuyer {

    fun chkNum(str: String) : Boolean {
        var temp: Char
        var result = false
        for (i in 0 until str.length) {
            temp = str.elementAt(i)
            if (temp.toInt() < 48 || temp.toInt() > 57) {
                result = true
            }
        }
        return result
    }

    fun inputLottoPurchasePrice(): Int {// 로또 구입 금액
        println(ConstMessage.ENTER_PURCHASE_PRICE)
        val inputPrice = Console.readLine()
        inputLottoPurchasePriceError(inputPrice)
        return inputPrice.toInt()
    }

    fun inputLottoPurchasePriceError(inputPrice: String) {// 로또 금액 예외처리
        when {
            inputPrice.toInt() < 1000 -> return throw IllegalArgumentException(ConstMessage.LESS_MONEY_EXCEPTION)
            inputPrice.toInt() % 1000 != 0 -> return throw IllegalArgumentException(ConstMessage.UNIT_OF_MONEY_EXCEPTION)
            chkNum(inputPrice) -> return throw IllegalArgumentException(ConstMessage.NON_NUMBER_EXCEPTION)
        }
    }

}