package lotto

import error.InputError
import resource.*

fun main() {
    val purchaseMoney = getPurchaseMoney()
}

fun getPurchaseMoney(): Int {
    println(INPUT_MONEY)

    val value = readLine()
    InputError.checkInteger(value)

    val money = value!!.toInt()
    InputError.checkValidMoney(money)

    return money
}
