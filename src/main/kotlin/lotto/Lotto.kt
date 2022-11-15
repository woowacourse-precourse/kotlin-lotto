package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun winningsCount(lotto: List<Int>): Int = numbers.filter { it ->
        lotto.contains(it)
    }.size

    fun isBonusTrue(bonus: Int): Boolean = numbers.contains(bonus)

}
