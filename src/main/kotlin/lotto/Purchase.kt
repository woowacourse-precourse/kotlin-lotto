package lotto

import data.LOTTERY_PRICE
import data.StringResource

class Purchase {

    fun createExpense(): Int {
        println(StringResource.PURCHASE.resource)
        val expense = readLine()!!.toInt()
        checkMoney(expense)
        return expense
    }

    fun checkMoney(money: Int) {
        val haveWrongMoney = (money % LOTTERY_PRICE != 0)
        if (haveWrongMoney) {
            throw IllegalArgumentException(StringResource.ERROR.resource)
        }
    }

    fun updateLottoQuantity(money: Int): Int {
        return money / LOTTERY_PRICE
    }

}
