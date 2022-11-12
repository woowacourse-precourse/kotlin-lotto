package lotto.util

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

private const val ERROR_NOT_NUMBER = "숫자를 입력해주세요."

fun Int.toPriceFormatted(): String = DecimalFormat("#,###").format(this)

fun readInt(): Int = try {
    Console.readLine().replace("\\s".toRegex(), "").toInt()
} catch (e: NumberFormatException) {
    throw IllegalArgumentException(ERROR_NOT_NUMBER)
}

