package lotto.util

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

fun Int.toPriceFormatted() = DecimalFormat("#,###")
    .format(this)

fun readInt(): Int {
    val num = Console.readLine()
        .toIntOrNull()
    requireWithPrefix(num != null, "숫자를 입력해주세요.")
    return num!!
}