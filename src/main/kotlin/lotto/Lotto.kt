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

    fun printLottoNumber() = println(numbers.sorted())

    fun confirmWinning(luckyNumber: List<Int>, bonusNumber: Int): Int {
        var rank = luckyNumber.filter { number ->
            numbers.contains(number)
        }.size
        if (numbers.contains(bonusNumber) && rank == 5) {
            rank = 7
        }
        return when (rank) {
            3 -> 5
            4 -> 4
            5 -> 3
            7 -> 2
            6 -> 1
            else -> 0
        }
    }
}
