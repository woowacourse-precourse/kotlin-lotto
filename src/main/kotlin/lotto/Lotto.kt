package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LIMIT_LOTTO_SIZE) { NUMBERS_SIZE_ERROR_MSG }
        require(numbers.toSet().size == LIMIT_LOTTO_SIZE) { NUMBERS_DISTINCT_ERROR_MSG }
        numbers.forEach { num ->
            require(MIN_NUM_LOTTO <= num && num <= MAX_NUM_LOTTO) { NUMBER_RANGE_ERROR_MSG }
        }
    }

    fun matchLotto(answer: Lotto, bonus: Int): LottoGrade {
        val count = countCompareLotto(answer)
        val bonusResult = matchBonus(bonus)

        when (count) {
            3 -> return LottoGrade.FIFTH
            4 -> return LottoGrade.FOURTH
            5 -> {
                if (bonusResult) return LottoGrade.SECOND
                return LottoGrade.THIRD
            }

            6 -> return LottoGrade.FIRST
            else -> return LottoGrade.NOTHING
        }
    }

    // TODO: 추가 기능 구현
    fun countCompareLotto(answer: Lotto): Int {
        val union = numbers + answer.numbers
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()

        return intersection.size
    }

    fun matchBonus(bonus: Int): Boolean = numbers.contains(bonus)

    fun printLotto() {
        println(numbers)
    }

    companion object {
        const val MIN_NUM_LOTTO = 1
        const val MAX_NUM_LOTTO = 45
        const val LIMIT_LOTTO_SIZE = 6
        const val NUMBERS_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 6개여야 합니다."
        const val NUMBERS_DISTINCT_ERROR_MSG = "[ERROR] 로또 번호는 중독되면 안됩니다."
        const val NUMBER_RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
