package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object Price {
    fun isNumber(string: String){
        if(string.toIntOrNull() == null)
            throw IllegalArgumentException("[ERROR] 구매 금액은 공백 없이 정수 형태여야 합니다.")
    }

    private fun isThousands(number: String) {
        if (number.toInt() % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 구매 금액은 천 단위의 수여야 합니다.")
    }

    private fun isPositiveNumber(number: String) {
        if (number.toInt() <= 0)
            throw IllegalArgumentException("[ERROR] 구매 금액은 0보다 큰 수여야 합니다.")
    }

    private fun isSatisfyPriceConditions(string: String) {
        isNumber(string)
        isThousands(string)
        isPositiveNumber(string)
    }

    private fun printEnterPurchasePriceMessage() = println("구매금액을 입력해주세요.")

    private fun enterPurchasePrice(): String {
        printEnterPurchasePriceMessage()

        return Console.readLine()
    }

    fun getPurchasePrice(): Int {
        val purchasePrice = enterPurchasePrice()

        isSatisfyPriceConditions(purchasePrice)

        return purchasePrice.toInt()
    }
}