package lotto.data

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LENGTH)
        require(numbers.distinct().size == LENGTH)
        require(numbers.all { it in Range })
    }

    companion object {
        const val LENGTH = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        val Range = MIN_NUMBER..MAX_NUMBER
    }
}
