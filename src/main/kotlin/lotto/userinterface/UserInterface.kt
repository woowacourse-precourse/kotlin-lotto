package lotto.userinterface

import camp.nextstep.edu.missionutils.Console
import lotto.service.dto.LottoDto
import java.math.BigInteger
import java.text.DecimalFormat


object UserInterface {

    private const val PURCHASE_AMOUNT_LIMIT = 2000000000
    private val decimalFormat = DecimalFormat("#,###")

    fun askPurchaseAmount(): Int {
        println(REQUEST_PURCHASE_AMOUNT)
        val readValue = Console.readLine()
        validatePurchaseAmount(readValue)
        val purchaseAmount = BigInteger(readValue)
        return purchaseAmount.toInt()
    }

    private fun validatePurchaseAmount(readValue: String) {
        require(readValue.all { it.isDigit() }) { PURCHASE_AMOUNT_NOT_DIGIT }
        val purchaseAmount = BigInteger(readValue)
        require(purchaseAmount <= BigInteger(PURCHASE_AMOUNT_LIMIT.toString())) {
            String.format(
                PURCHASE_AMOUNT_EXCESS_LIMIT,
                decimalFormat.format(PURCHASE_AMOUNT_LIMIT)
            )
        }
        require(
            purchaseAmount.mod(BigInteger("1000")).equals(BigInteger.ZERO)
        ) { PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000 }
    }

    fun showPurchaseResult(lotteries: List<LottoDto>) {
        println(String.format(PURCHASE_RESULT, lotteries.size))
        lotteries.forEach { println(it.numbers()) }
    }
}