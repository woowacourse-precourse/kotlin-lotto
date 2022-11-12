package lotto.domain

import lotto.domain.ExceptionHandler.checkInputPurchasingAmount

class Service {
    fun getPurchasingAmount(): Int {
        val inputPurchasingAmount = Util.readLine()
        checkInputPurchasingAmount(inputPurchasingAmount)
        return (inputPurchasingAmount.toInt() / 1000)
    }
}