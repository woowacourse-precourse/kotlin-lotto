package lotto.lottoshop

import lotto.LottoPhrases.MAIN_LOTTO_NUMBER_INPUT_TYPE_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_INPUT_TYPE_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_MINIMUM_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_UNIT_ERROR
import java.util.regex.Pattern

class LottoShop() {

    fun getValidatePurchaseAmount(purchaseAmount: String): Int {
        if (!isInputTypeNumber(purchaseAmount)) printErrorMessage(PURCHASE_AMOUNT_INPUT_TYPE_ERROR)
        val processedPurchaseAmount = convertToInt(purchaseAmount)
        checkMinimumPurchaseAmount(processedPurchaseAmount)
        checkCorrectUnitPurchaseAmount(processedPurchaseAmount)
        return processedPurchaseAmount
    }

    private fun checkMinimumPurchaseAmount(purchaseAmount: Int) {
        if (purchaseAmount < 1000) printErrorMessage(PURCHASE_AMOUNT_MINIMUM_ERROR)
    }

    private fun checkCorrectUnitPurchaseAmount(purchaseAmount: Int) {
        if (purchaseAmount % 1000 != 0) printErrorMessage(PURCHASE_AMOUNT_UNIT_ERROR)
    }

    fun getValidateMainLottoNumbers(mainLottoNumbers: List<String>): List<Int> {
        if (!isInputTypeNumber(mainLottoNumbers)) printErrorMessage(MAIN_LOTTO_NUMBER_INPUT_TYPE_ERROR)
        val processedMainLottoNumbers = convertToInt(mainLottoNumbers)
    }

    private fun isInputTypeNumber(input: List<String>): Boolean {
        var hasOnlyInt = true
        for (mainLottoNumber in input) if (!isInputTypeNumber(mainLottoNumber)) hasOnlyInt = false
        return hasOnlyInt
    }

    private fun convertToInt(input: List<String>): List<Int> {
        val processedMainLottoNumbers = mutableListOf<Int>()
        for (mainLottoNumber in input) processedMainLottoNumbers.add(mainLottoNumber.toInt())
        return processedMainLottoNumbers
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
