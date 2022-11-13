package lotto.userinterface

import camp.nextstep.edu.missionutils.Console


object UserInterface {

    fun askPurchaseAmount(): Int {
        val readValue = Console.readLine()
        require(readValue.all { it.isDigit() }) { PURCHASE_AMOUNT_NOT_DIGIT }
        return 0
    }
}