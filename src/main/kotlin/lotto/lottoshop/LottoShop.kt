package lotto.lottoshop

import java.util.regex.Pattern

class LottoShop() {

    fun getValidatePurchaseAmount(purchaseAmount: String): Int {
    }

    fun getValidateMainLottoNumbers(mainLottoNumbers: List<String>): List<Int> {
    }

    fun getValidateBonusLottoNumber(bonusLottoNumber: String): Int {
    }

    fun isInputTypeNumber(input: String): Boolean = Pattern.matches("^[0-9]+$", input)

    fun convertToInt(input: String): Int = input.toInt()

    fun printErrorMessage(errorMessage: String) {
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
}
