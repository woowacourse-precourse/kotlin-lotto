package lotto.domain

private const val DEFAULT_LOTTO_SIZE = 6

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == DEFAULT_LOTTO_SIZE)
        require(numbers.toSet().size == DEFAULT_LOTTO_SIZE)
    }

    fun checkWinningNumbersMatching(winningNumbers: List<Int>): Int {
        return numbers.filter { winningNumbers.contains(it) }.size
    }

    fun checkBonusNumberMatching(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun returnNumbers(): List<Int> {
        return numbers
    }
}
