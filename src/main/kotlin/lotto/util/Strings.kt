package lotto.util

private const val ERROR_DIVIDE_NUMBER_FORMAT = "숫자를 %s로 구분해서 입력해 주세요."

fun String.divideToNums(delimiters: String): List<Int> =
    try {
        this.replace("\\s".toRegex(), "")
            .split(delimiters)
            .map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_DIVIDE_NUMBER_FORMAT.format(delimiters))
    }

