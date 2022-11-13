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

fun String.isNumeric(): Boolean {
    return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
}

fun List<String>.isInRange(): Boolean {
    this.forEach { number ->
        if (number.toInt() > MAXIMUM_LOTTO_NUMBER || number.toInt() < MINIMUM_LOTTO_NUMBER) {
            return false
        }
    }
    return true
}

fun String.isInRange(): Boolean = this.toInt() in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER