package lotto.util

private const val ERROR_DIVIDE_NUMBER_FORMAT = "숫자를 %s로 구분해서 입력해 주세요."

fun String.divideToNums(delimiters: String): List<Int> {
    val trimmed = this.replace("\\s".toRegex(), "")
    val parsed = trimmed.split(delimiters)
    val nums = mutableListOf<Int>()
    for (str in parsed) {
        val num = str.toIntOrNull()
        require(num != null) { ERROR_DIVIDE_NUMBER_FORMAT.format(delimiters) }
        nums.add(num)
    }
    return nums
}
