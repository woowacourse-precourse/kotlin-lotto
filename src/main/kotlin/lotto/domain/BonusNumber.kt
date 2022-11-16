package lotto.domain

import lotto.enum.Configuration
import lotto.enum.ErrorString

class BonusNumber(private val number: Int) {
    init {
        require(number in Configuration.START_LOTTO_NUMBER.number..Configuration.END_LOTTO_NUMBER.number) {
            ErrorString.OUT_OF_BOUND
        }
    }

    fun isMatched(winningNumbers: List<Int>) = winningNumbers.contains(number)
}