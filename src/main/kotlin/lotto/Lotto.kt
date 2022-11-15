package lotto

enum class Rank {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    ERROR
};

class Lotto(private val numbers: List<Int>) {
    var winningNumbers: List<Int>
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        winningNumbers = numbers
    }
    fun printLottoNumbers() {
        println(numbers)
    }
    fun compareLottoNumbers(numbers: List<Int>): Rank {
        val union = winningNumbers + numbers
        val sameNumberCount = union
            .groupBy { it }
            .filter { it.value.size != 1 }
            .flatMap { it.value }.size / 2
        when (sameNumberCount) {
            0 -> return Rank.ZERO
            1 -> return Rank.ONE
            2 -> return Rank.TWO
            3 -> return Rank.THREE
            4 -> return Rank.FOUR
            5 -> return Rank.FIVE
            6 -> return Rank.SIX
        }
        return Rank.ERROR
    }
}
