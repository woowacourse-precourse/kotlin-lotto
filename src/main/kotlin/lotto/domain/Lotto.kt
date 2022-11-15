package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        checkValidation()
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber: Int): Rank {
        return Rank.FIRST
    }

    fun getTicket(): String {
        return numbers.toString()
    }

    private fun checkValidation() {
        require(numbers.size == LOTTO_SIZE) { SIZE_ERROR_MESSAGE }
        numbers.map { number -> require(number in START_NUMBER..END_NUMBER) { RANGE_ERROR_MESSAGE } }
        require(numbers.distinct().size == numbers.size) { DISTINCT_ERROR_MESSAGE }
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val START_NUMBER = 1
        const val END_NUMBER = 45
        const val SIZE_ERROR_MESSAGE = "로또 번호가 6개가 아닙니다."
        const val RANGE_ERROR_MESSAGE = "로또 번호가 1 ~ 45 사이의 숫자가 아닙니다."
        const val DISTINCT_ERROR_MESSAGE = "로또 번호가 중복됩니다."
    }
}
