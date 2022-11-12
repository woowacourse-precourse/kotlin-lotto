package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import utils.Constants
import utils.Constants.ERROR_MESSAGE_NOT_1000WON
import utils.Constants.ERROR_MESSAGE_OUT_OF_RANGE

class Lotto(private val numbers: List<Int>) {
    private val display = Display()

    init {
        require(numbers.size == 6)
        require(!isReduplicateNumber())
    }

    private fun isReduplicateNumber(): Boolean {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] == numbers[i + 1])
                return true
        }
        return false
    }

    fun start(bonusNumber: Int) {
        display.printRequirePurchaseAmount()
        val purchaseAmount = readLine()
        checkPurchaseAmount(purchaseAmount)
        val purchaseCount = purchaseAmount.toInt() / 1000

    }

    fun checkPurchaseAmount(amount: String) {
        // 1. 숫자 외 문자일 경우
        val amountNumber = amount.toIntOrNull() ?:
        throw IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE)

        // 2. 1000원 단위인지
        if (amountNumber % 1000 != 0)
            throw IllegalArgumentException(ERROR_MESSAGE_NOT_1000WON)
    }


}

