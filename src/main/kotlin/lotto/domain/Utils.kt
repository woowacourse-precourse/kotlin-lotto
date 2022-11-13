package lotto.domain

fun String.splitToIntList(separator: String = ","): List<Int> {
    return this.split(separator)
        .map { it.toIntOrNull().checkNull() }
}

fun Int?.checkNull(): Int {
    requireNotNull(this) { "[ERROR] 숫자만 입력해주세요." }
    return this
}
