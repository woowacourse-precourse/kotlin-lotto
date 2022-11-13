package lotto

fun List<String>.hasOverLappedNumber(): Boolean {
    val existNumber = mutableSetOf<String>()

    this.forEach { number ->
        if (existNumber.contains(number)) {
            return true
        }
        existNumber.add(number)
    }
    return false
}