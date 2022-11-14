package lotto.data

import lotto.error.ErrorMessages

private typealias LottoError = ErrorMessages.LottoEnum

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LENGTH) { LottoError.RequiredSixLength }
        require(numbers.distinct().size == LENGTH) { LottoError.NotDuplicated }
        require(numbers.all { it in Range }) { LottoError.OutOfRangeNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun matches(other: Lotto): Int {
        return numbers.count { other.contains(it) }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    companion object {
        const val LENGTH = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        val Range = MIN_NUMBER..MAX_NUMBER
    }
}
