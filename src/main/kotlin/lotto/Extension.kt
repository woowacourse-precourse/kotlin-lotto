package lotto

/**
 * 여러 클래스에서 쓰이는 extension 함수를 정의한 곳
 */
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