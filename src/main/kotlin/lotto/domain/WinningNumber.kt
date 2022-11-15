package lotto.domain

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    init {
        validateNumbersSize()
        validateNumbersRange()
        validateNumbersDuplicated()
        validateBonusNumberRange()
        validateBonusNumberThatIsIncludedInNumbers()
    }

    private fun validateNumbersSize() =
        require(numbers.size == LOTTO_NUMBERS_SIZE)

    private fun validateNumbersRange() =
        require(numbers.all { it in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END })

    private fun validateNumbersDuplicated() =
        require(numbers.toSet().size == numbers.size)

    private fun validateBonusNumberRange() =
        require(bonusNumber in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END)

    private fun validateBonusNumberThatIsIncludedInNumbers() =
        require(bonusNumber !in numbers)

    fun numbers() = numbers

    fun bonusNumber() = bonusNumber
}