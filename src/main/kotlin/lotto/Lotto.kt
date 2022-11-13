package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS)
        require(!numbers.map { it.toString() }.hasOverLappedNumber())
    }

    fun printLottoNumbers() = println(numbers)

    fun checkLotto(winningNumber: List<Int>, bonusNumber: Int): LottoPrice {
        val catchCount = numbers.filter { number -> winningNumber.contains(number) }.size
        var result = LottoPrice.NONE

        when (catchCount) {
            3 -> result = LottoPrice.FIFTH_PLACE
            4 -> result = LottoPrice.FOURTH_PLACE
            5 -> result = if (!numbers.contains(bonusNumber)) {
                LottoPrice.THIRD_PLACE
            } else {
                LottoPrice.SECOND_PLACE
            }
            6 -> result = LottoPrice.FIRST_PLACE
        }
        return result
    }
}
