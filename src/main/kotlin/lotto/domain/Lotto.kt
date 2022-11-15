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
        if (!isRepeated(numbers)) {
            throw IllegalArgumentException()
        }
    }

    private fun isRepeated(numbers: List<Int>): Boolean {
        return numbers.distinct().count() == 6
    }

    override fun toString(): String {
        return "[${numbers[0]}, ${numbers[1]}, ${numbers[2]}, ${numbers[3]}, ${numbers[4]}, ${numbers[5]}]"
    }
}
