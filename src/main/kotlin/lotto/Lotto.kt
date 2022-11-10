package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getSortedNumbers(): List<Int> = numbers.sorted()
}
