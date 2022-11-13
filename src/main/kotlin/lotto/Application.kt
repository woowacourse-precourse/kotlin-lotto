package lotto

import lotto.domain.GetPrice
import lotto.ui.Input

fun main() {
    val price = getMoney()

}

fun getMoney(): Int {
    val strPrice = Input.getPrice()
    return GetPrice.getNum(strPrice)
}