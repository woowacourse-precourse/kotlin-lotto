package lotto.lottoshop

import lotto.LottoPhrases.PURCHASE_AMOUNT_INPUT_TYPE_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_MINIMUM_ERROR
import java.util.regex.Pattern

class LottoShop() {

    fun getValidatePurchaseAmount(purchaseAmount: String): Int {
        if (!isInputTypeNumber(purchaseAmount)) printErrorMessage(PURCHASE_AMOUNT_INPUT_TYPE_ERROR)
        val processedPurchaseAmount = convertToInt(purchaseAmount)
        checkMinimumPurchaseAmount(processedPurchaseAmount)
    }

    private fun checkMinimumPurchaseAmount(purchaseAmount: Int) {
        if (purchaseAmount < 1000) printErrorMessage(PURCHASE_AMOUNT_MINIMUM_ERROR)
    }

    fun getValidateMainLottoNumbers(mainLottoNumbers: List<String>): List<Int> {
    }

    fun getValidateBonusLottoNumber(bonusLottoNumber: String): Int {
    }

    private fun isInputTypeNumber(input: String): Boolean = Pattern.matches("^[0-9]+$", input)

    private fun convertToInt(input: String): Int = input.toInt()

    private fun printErrorMessage(errorMessage: String) {
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
}
