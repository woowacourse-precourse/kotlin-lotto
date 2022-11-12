package lotto.util

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

private const val ERROR_NOT_NUMBER = "숫자를 입력해주세요."
private const val ERROR_DIVIDE_NUMBER_FORMAT = "숫자를 %s로 구분해서 입력해 주세요."

fun Int.toPriceFormatted(): String = DecimalFormat("#,###").format(this)

fun readNumber(): Int = try {
    Console.readLine()
        .replace("\\s".toRegex(), "")
        .toInt()
} catch (e: NumberFormatException) {
    throw IllegalArgumentException(ERROR_NOT_NUMBER)
}

fun readNumbers(delimiters: String = ","): List<Int> = try {
    Console.readLine()
        .replace("\\s".toRegex(), "")
        .split(delimiters)
        .map { it.toInt() }
} catch (e: NumberFormatException) {
    throw IllegalArgumentException(ERROR_DIVIDE_NUMBER_FORMAT.format(delimiters))
}
