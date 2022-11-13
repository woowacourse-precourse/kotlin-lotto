package lotto.domain

import lotto.resources.ERROR_INPUT_VALUE_NUMBER_ONLY

fun String.splitToIntList(separator: String = ","): List<Int> {
    return this.split(separator)
        .map { it.toIntOrNull().checkNull() }
}

fun Int?.checkNull(): Int {
    requireNotNull(this) { ERROR_INPUT_VALUE_NUMBER_ONLY }
    return this
}
