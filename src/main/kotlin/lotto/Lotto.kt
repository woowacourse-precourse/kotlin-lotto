package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS)
        require(!numbers.map { it.toString() }.hasOverLappedNumber())
    }

    fun checkLottoNumbers() = numbers

    fun checkLotto(winningNumber: List<Int>, bonusNumber: Int): LottoPlace {
        val catchCount = numbers.filter { number -> winningNumber.contains(number) }.size
        var result = LottoPlace.NONE

        when (catchCount) {
            3 -> result = LottoPlace.FIFTH_PLACE
            4 -> result = LottoPlace.FOURTH_PLACE
            5 -> result = if (!numbers.contains(bonusNumber)) {
                LottoPlace.THIRD_PLACE
            } else {
                LottoPlace.SECOND_PLACE
            }
            6 -> result = LottoPlace.FIRST_PLACE
        }
        return result
    }
}
