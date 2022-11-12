package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        validateSize()
        validateDuplicate()
    }

    private fun validateSize() = require(numbers.size == Constant.LOTTO_COUNT) {
        ErrorMessage.sizeError(Constant.LOTTO_NUMBER)
    }

    private fun validateDuplicate() = require(numbers.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicateError(Constant.LOTTO_NUMBER)
    }

    fun getLottoNumber() = numbers.sorted()

    fun confirmWinning(winningNumber: List<Int>, bonusNumber: Int): Int {
        val match = winningNumber.filter { number ->
            numbers.contains(number)
        }.size
        if (numbers.contains(bonusNumber) && match == Constant.FIVE_MATCH) {
            return Constant.SECOND
        }
        return getRank(match)
    }

    private fun getRank(match: Int): Int {
        return when (match) {
            Constant.THREE_MATCH -> Constant.FIFTH
            Constant.FOUR_MATCH -> Constant.FOURTH
            Constant.FIVE_MATCH -> Constant.THIRD
            Constant.SIX_MATCH -> Constant.FIRST
            else -> Constant.NOTHING
        }
    }
}
