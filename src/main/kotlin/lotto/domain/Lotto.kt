package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LOTTO_SIZE_EXCEPTION }
        require(numbers.distinct().size == 6) { LOTTO_DUPLICATE_EXCEPTION }
        require(numbers.all { it in 1..45 }) { LOTTO_RANGE_EXCEPTION }
    }

    override fun toString(): String {
        val sortedNumbers = numbers.sorted()
        return sortedNumbers.joinToString(", ")
    }

    companion object {
        const val LOTTO_SIZE_EXCEPTION = "[ERROR] 로또 번호의 갯수는 6개 입니다."
        const val LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 로또 번호는 중복이 있으면 안됩니다."
        const val LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
