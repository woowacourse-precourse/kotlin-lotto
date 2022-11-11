package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasNotDuplicateNumber())
        require(isVaildAscendingOrder())
    }

    fun getMachingLottoNumberCount(otherNumbers: List<Int>): Int =
        numbers.intersect(otherNumbers).size

    private fun hasNotDuplicateNumber(): Boolean =
        numbers.size == numbers.distinct().size

    private fun isVaildAscendingOrder(): Boolean =
        numbers == numbers.sorted()
}
