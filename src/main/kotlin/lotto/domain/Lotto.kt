package lotto.domain

data class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        validateLottoNumber(numbers)
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    private fun validateLottoNumber(numbers: List<Int>) {
        if (!isNumber(numbers)) {
            throw IllegalArgumentException()
        }
        if (!isRepeated(numbers)) {
            throw IllegalArgumentException()
        }
    }

    private fun isRepeated(numbers: List<Int>): Boolean {
        if (numbers.distinct().count() != 6) {
            return false
        }
        return true
    }

    private fun isNumber(numbers: List<Int>): Boolean {
        for (number in numbers) {
            if (!number.toString().all { it.isDigit() }) {
                return false
            }
        }
        return true
    }

    override fun toString(): String {
        return "[${numbers[0]}, ${numbers[1]}, ${numbers[2]}, ${numbers[3]}, ${numbers[4]}, ${numbers[5]}]"
    }
}
