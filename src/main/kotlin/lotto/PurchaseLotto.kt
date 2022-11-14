package lotto

import camp.nextstep.edu.missionutils.Console

class PurchaseLotto {
    private fun isNumber(inputPrice : String?) : Boolean {
        return if(inputPrice.isNullOrEmpty()) false
        else inputPrice.all{Character.isDigit(it)}
    }

    fun purchase() : Int {
        println("구매금액을 입력해 주세요.")

        val inputMoney = Console.readLine()!!.trim()

        if(!isNumber(inputMoney)) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력하셔야 됩니다.")
        }
        if(inputMoney.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.")
        }

        return inputMoney.toInt()
    }

    fun issuedLotto(money : Int) : Int{
        return money / 1000
    }
}