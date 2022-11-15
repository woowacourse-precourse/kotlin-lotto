package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        require(numbers.distinct().size == LOTTO_SIZE)
        numbers.forEach {
            require(it in MIN_NUMBER..MAX_NUMBER)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        val MIN_NUMBER = 1
        val MAX_NUMBER = 45
        val LOTTO_SIZE = 6
        val LOTTO_PRICE = 1000
    }
}
