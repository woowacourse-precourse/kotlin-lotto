package lotto.domain

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE)
        require(numbers.all { it in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END })
        require(numbers.toSet().size == numbers.size)
        require(bonusNumber !in numbers)
    }

    fun numbers() = numbers

    fun bonusNumber() = bonusNumber
}