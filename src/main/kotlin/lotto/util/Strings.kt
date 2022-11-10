package lotto.util

import java.text.DecimalFormat


fun String.divideToNumsOrNull(delimiters: String): List<Int>? {
    val parsed = this.split(delimiters)
    val nums = mutableListOf<Int>()
    for (str in parsed) {
        val num = str.toIntOrNull() ?: return null
        nums.add(num)
    }
    return nums
}

fun Int.toPriceFormatted() = DecimalFormat("#,###")
    .format(this)