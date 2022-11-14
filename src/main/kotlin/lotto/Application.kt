package lotto

import error.InputError
import resource.*

fun main() {
    val purchaseMoney = getPurchaseMoney()
}

fun getPurchaseMoney(): Int {
    println(INPUT_MONEY)
    val money = readLine()

    InputError.checkInteger(money)

    return money!!.toInt()
}
