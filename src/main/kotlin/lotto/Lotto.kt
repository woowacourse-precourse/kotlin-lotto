package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!hasDuplicateNumber(numbers))
    }

    private fun hasDuplicateNumber(numbers: List<Int>): Boolean {
        val eachNumber = numbers.toSet()
        return eachNumber.size != 6
    }
}
