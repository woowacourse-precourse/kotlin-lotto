package lotto

import lotto.constants.INPUT_PURCHASE_AMOUNT_ERROR_MSG


class User(money: String) {
    val numOfLotto: Int
    var earningMoney: Long
    val purchaseMoney: Long
    var winCase= MutableList(5){0}

    init {
        for (i in money) {
            require(i in '0'..'9') { println(INPUT_PURCHASE_AMOUNT_ERROR_MSG) }
        }
        require(money.toLong() % 1000 == 0L) { println(INPUT_PURCHASE_AMOUNT_ERROR_MSG) }

        purchaseMoney = money.toLong()
        numOfLotto = (purchaseMoney / 1000).toInt()
        earningMoney = 0L
    }

}