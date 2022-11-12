package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkLotto(winningNumber: List<Int>, bonusNumber: Int): LottoStatus {
        val catchCount = numbers.filter { number -> winningNumber.contains(number) }.size
        var result = LottoStatus.NONE

        when (catchCount) {
            3 -> result = LottoStatus.FIFTH_PLACE
            4 -> result = LottoStatus.FOURTH_PLACE
            5 -> result = if (!numbers.contains(bonusNumber)) {
                LottoStatus.THIRD_PLACE
            } else {
                LottoStatus.SECOND_PLACE
            }
            6 -> result = LottoStatus.FIRST_PLACE
        }
        return result
    }
}
