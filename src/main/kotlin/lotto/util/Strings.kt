package lotto.util

fun String.divideToNums(delimiters: String): List<Int> {
    val trimmed = this.replace("\\s".toRegex(), "")
    val parsed = trimmed.split(delimiters)
    val nums = mutableListOf<Int>()
    for (str in parsed) {
        val num = str.toIntOrNull()
        requireWithPrefix(num != null, "숫자를 ${delimiters}로 구분해서 입력해 주세요.")
        nums.add(num!!)
    }
    return nums
}
