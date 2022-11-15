package lotto.domain

import lotto.enum.Configuration
import lotto.enum.ErrorString

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Configuration.LOTTO_SIZE.number) {
            ErrorString.LOTTO_SIZE.string
        }
        require(numbers.distinct().size == Configuration.LOTTO_SIZE.number) {
            ErrorString.DUPLICATED_DRAWN_NUMBERS
        }
        require(numbers.all { number ->
            number in Configuration.START_LOTTO_NUMBER.number..Configuration.END_LOTTO_NUMBER.number
        }) {
            ErrorString.OUT_OF_BOUND
        }
    }

    private fun contains(number: Int) = numbers.contains(number)

    fun compare(winningLotto: Lotto, bonusNumber: BonusNumber): Pair<Int, Boolean> {
        return numbers.count { number ->
            winningLotto.contains(number)
        } to bonusNumber.isMatched(numbers)
    }

    override fun toString(): String = numbers.toString()
}
