package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun winningsCount(lotto: List<Int>): Int = numbers.filterIndexed { idx, it ->
        it == lotto[idx]
    }.size

    fun isBonusTrue(bonus: Int): Boolean = numbers.contains(bonus)

}
