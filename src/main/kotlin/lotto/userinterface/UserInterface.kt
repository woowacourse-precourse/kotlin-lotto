package lotto.userinterface

import camp.nextstep.edu.missionutils.Console
import java.math.BigInteger
import java.text.DecimalFormat


object UserInterface {

    private const val PURCHASE_AMOUNT_LIMIT = 2000000000
    private val decimalFormat = DecimalFormat("#,###")

    fun askPurchaseAmount(): Int {
        val readValue = Console.readLine()
        require(readValue.all { it.isDigit() }) { PURCHASE_AMOUNT_NOT_DIGIT }
        val purchaseAmount = BigInteger(readValue)
        require(purchaseAmount <= BigInteger(PURCHASE_AMOUNT_LIMIT.toString())) {
            String.format(
                PURCHASE_AMOUNT_EXCESS_LIMIT,
                decimalFormat.format(PURCHASE_AMOUNT_LIMIT)
            )
        }
        return 0
    }
}