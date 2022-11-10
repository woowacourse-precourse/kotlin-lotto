package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasNotDuplicateNumber())
        require(isVaildAscendingOrder())
    }

    private fun hasNotDuplicateNumber(): Boolean =
        numbers.size == numbers.distinct().size

    private fun isVaildAscendingOrder(): Boolean =
        numbers == numbers.sorted()
}
