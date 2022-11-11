package lotto.util

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

fun Int.toPriceFormatted(): String = DecimalFormat("#,###")
    .format(this)

fun readInt(): Int {
    val num = Console.readLine()
        .replace("\\s".toRegex(), "")
        .toIntOrNull()
    requireWithPrefix(num != null, "숫자를 입력해주세요.")
    return num!!
}
