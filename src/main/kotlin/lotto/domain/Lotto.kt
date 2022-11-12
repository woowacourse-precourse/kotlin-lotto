package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LENGTH) { ERROR_LOTTO_LENGTH }
        require(numbers.all { it in MIN_NUM..MAX_NUM }) { ERROR_LOTTO_NUM_RANGE }
        require(numbers == numbers.distinct()) { ERROR_LOTTO_NUM_DUPLICATED }
    }

    operator fun contains(num: Int) = num in numbers

    fun compare(other: Lotto) = numbers.count { it in other }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LENGTH = 6
        const val MAX_NUM = 45
        const val MIN_NUM = 1
        const val COST = 1000

        private const val ERROR_LOTTO_LENGTH = "로또 번호는 ${LENGTH}개의 숫자여야 합니다."
        private const val ERROR_LOTTO_NUM_RANGE = "로또 번호는 ${MIN_NUM}부터 $MAX_NUM 사이의 숫자여야 합니다."
        private const val ERROR_LOTTO_NUM_DUPLICATED = "로또 번호에는 중복되는 숫자가 없어야 합니다."
    }
}
