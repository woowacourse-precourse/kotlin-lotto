package lotto

const val ERROR = "[ERROR] "
const val IS_EMPTY_VALUE = "빈 값은 입력될 수 없습니다."
const val CONTAINS_BLANK = "공백은 포함될 수 없습니다."
const val NOT_CONSIST_OF_NUMBER = "숫자로 구성되어 있지않습니다."
const val NOT_LOTTO_NUMBER_RANGE = "1부터 45까지의 숫자가 아닙니다. "
const val LOTTO_START_NUMBER = 1
const val LOTTO_END_NUMBER = 45
const val LOTTO_PRICE = 1000
const val THE_NUMBER_OF_WIN_NUMBERS = 6
const val THE_NUMBER_OF_WIN_NUMBERS_COMMA = 5

fun validateUserInputPurchasingAmount(userInputPurchasingAmount: String) {
    if (userInputPurchasingAmount.isEmpty()) {
        throw IllegalArgumentException(ERROR + IS_EMPTY_VALUE)
    }
    if (userInputPurchasingAmount.contains(" ")) {
        throw IllegalArgumentException(ERROR + CONTAINS_BLANK)
    }
    if (!userInputPurchasingAmount.matches(Regex("^\\d*\$"))) {
        throw IllegalArgumentException(ERROR + NOT_CONSIST_OF_NUMBER)
    }
    val purchasingAmount = userInputPurchasingAmount.toLong()
    if (purchasingAmount % LOTTO_PRICE != 0L) {
        throw IllegalArgumentException("${ERROR}1000원 단위로 입력해주세요.")
    }
}

fun validateUserInputWinNumbers(userInputWinNumbers: String) {
    if (userInputWinNumbers.isEmpty()) {
        throw IllegalArgumentException(ERROR + IS_EMPTY_VALUE)
    }
    if (userInputWinNumbers.contains(" ")) {
        throw IllegalArgumentException(ERROR + CONTAINS_BLANK)
    }
    if (userInputWinNumbers.count { it == ',' } != THE_NUMBER_OF_WIN_NUMBERS_COMMA) {
        throw IllegalArgumentException("${ERROR}, 로 구분해서 당첨숫자 6개를 입력해주세요.")
    }
    if (userInputWinNumbers.split(",").distinct().size < THE_NUMBER_OF_WIN_NUMBERS) {
        throw IllegalArgumentException("${ERROR}서로 다른 수로 이루어져야합니다.")
    }
    val winNumbers = userInputWinNumbers.split(",")
    for (winNumber in winNumbers) {
        if (winNumber.isEmpty()) {
            throw IllegalArgumentException(ERROR + IS_EMPTY_VALUE)
        }
        if (!winNumber.matches(Regex("\\d"))) {
            throw IllegalArgumentException(ERROR + NOT_CONSIST_OF_NUMBER)
        }
        if (winNumber.toInt() !in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
            throw IllegalArgumentException(ERROR + NOT_LOTTO_NUMBER_RANGE)
        }
    }
}

fun validateUserInputBonusNumber(userInputBonusNumber: String) {
    if (userInputBonusNumber.isEmpty()) {
        throw IllegalArgumentException(ERROR + IS_EMPTY_VALUE)
    }
    if (userInputBonusNumber.contains(" ")) {
        throw IllegalArgumentException(ERROR + CONTAINS_BLANK)
    }
    if (!userInputBonusNumber.matches(Regex("^\\d*\$"))) {
        throw IllegalArgumentException(ERROR + NOT_CONSIST_OF_NUMBER)
    }
    val bonusNumber = userInputBonusNumber.toInt()
    if (bonusNumber !in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
        throw IllegalArgumentException(ERROR + NOT_LOTTO_NUMBER_RANGE)
    }
}