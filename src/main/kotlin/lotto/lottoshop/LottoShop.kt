package lotto.lottoshop

import lotto.LottoPhrases.BONUS_LOTTO_NUMBER_INPUT_TYPE_ERROR
import lotto.LottoPhrases.DUPLICATE_LOTTO_NUMBER_ERROR
import lotto.LottoPhrases.LOTTO_NUMBER_NOT_IN_CORRECT_RANGE_ERROR
import lotto.LottoPhrases.MAIN_LOTTO_NUMBER_INPUT_SIZE_ERROR
import lotto.LottoPhrases.MAIN_LOTTO_NUMBER_INPUT_TYPE_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_INPUT_TYPE_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_MINIMUM_ERROR
import lotto.LottoPhrases.PURCHASE_AMOUNT_UNIT_ERROR
import lotto.LottoRule.LOTTO_NUMBER_RANGE_END
import lotto.LottoRule.LOTTO_NUMBER_RANGE_START
import lotto.LottoRule.LOTTO_SIZE
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
        checkCorrectSizeMainLottoNumbers(processedMainLottoNumbers)
        for (mainLottoNumber in processedMainLottoNumbers) checkCorrectNumberRange(mainLottoNumber)
        return processedMainLottoNumbers
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

    private fun checkCorrectSizeMainLottoNumbers(mainLottoNumbers: List<Int>) {
        if (mainLottoNumbers.size != LOTTO_SIZE) printErrorMessage(MAIN_LOTTO_NUMBER_INPUT_SIZE_ERROR)
    }

    fun getValidateBonusLottoNumber(bonusLottoNumber: String): Int {
        if (!isInputTypeNumber(bonusLottoNumber)) printErrorMessage(BONUS_LOTTO_NUMBER_INPUT_TYPE_ERROR)
        val processedBonusLottoNumber = convertToInt(bonusLottoNumber)
        checkCorrectNumberRange(processedBonusLottoNumber)
        return processedBonusLottoNumber
    }

    private fun isInputTypeNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

    private fun convertToInt(input: String): Int = input.toInt()

    private fun printErrorMessage(errorMessage: String) {
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }

    private fun checkCorrectNumberRange(lottoNumber: Int) {
        if (lottoNumber !in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END) printErrorMessage(
            LOTTO_NUMBER_NOT_IN_CORRECT_RANGE_ERROR
        )
    }

    fun checkLottoNumberDuplicate(lottoNumbers: List<Int>) {
        if (lottoNumbers.size != lottoNumbers.toSet().size) printErrorMessage(DUPLICATE_LOTTO_NUMBER_ERROR)
    }
}
