package lotto

const val ERROR = "[ERROR] "
const val IS_EMPTY_VALUE = "빈 값은 입력될 수 없습니다."
const val CONTAINS_BLANK = "공백을 포함될 수 없습니다."
const val NOT_CONSIST_OF_NUMBER = "숫자로 구성되어 있지않습니다."
const val NOT_LOTTO_NUMBER_RANGE = "1부터 45까지의 숫자가 아닙니다. "

fun validationUserInputWinNumbers(userInputWinNumbers: String) {
    if (userInputWinNumbers.isEmpty()) {
        throw IllegalArgumentException(ERROR + IS_EMPTY_VALUE)
    }
    if (userInputWinNumbers.contains(" ")) {
        throw IllegalArgumentException(ERROR + CONTAINS_BLANK)
    }
    if (userInputWinNumbers.count { it == ',' } != 5) {
        throw IllegalArgumentException("${ERROR}, 로 구분해서 당첨숫자 6개를 입력해주세요.")
    }
    if (userInputWinNumbers.split(",").distinct().size < 6) {
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
        if (winNumber.toInt() < 1 || winNumber.toInt() > 45) {
            throw IllegalArgumentException(ERROR + NOT_LOTTO_NUMBER_RANGE)
        }
    }
}