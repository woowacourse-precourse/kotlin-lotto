package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6) { ERROR_MESSAGE_NUMBER_COUNT }
        require(!numbers.map { it in 1..45 }.contains(false)) { ERROR_MESSAGE_RANGE }
    }

    fun getSortedNumbers(): List<Int> = numbers.sorted()

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
        private const val ERROR_MESSAGE_RANGE = "$ERROR_MESSAGE 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val ERROR_MESSAGE_NUMBER_COUNT = "$ERROR_MESSAGE 중복된 숫자를 제외하고 6개의 숫자가 존재해야 합니다."
    }
}