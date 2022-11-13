package lotto.userinterface

import camp.nextstep.edu.missionutils.Console
import java.math.BigInteger


object UserInterface {

    private const val PURCHASE_AMOUNT_LIMIT = 2000000000

    fun askPurchaseAmount(): Int {
        val readValue = Console.readLine()
        require(readValue.all { it.isDigit() }) { PURCHASE_AMOUNT_NOT_DIGIT }
        val purchaseAmount = BigInteger(readValue)
        require(purchaseAmount <= BigInteger(PURCHASE_AMOUNT_LIMIT.toString())) {
            String.format(
                PURCHASE_AMOUNT_EXCESS_LIMIT,
                PURCHASE_AMOUNT_LIMIT
            )
        }
        return 0
    }
}