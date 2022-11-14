package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { println(ERROR_MESSAGE_NUMBER_OUT_RANGE) }
        require(numbers.all { number ->
            numbers.count { it == number } < 1
        }) { println(ERROR_MESSAGE_NOT_DUPLICATION) }
    }

}
