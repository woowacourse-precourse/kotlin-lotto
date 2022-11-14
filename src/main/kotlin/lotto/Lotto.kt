package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkWinningNumbersMatching(winningNumbers: List<Int>): Int {
        return numbers.filter { winningNumbers.contains(it) }.size
    }

    fun checkBonusNumberMatching(bonusNumebr: Int): Boolean {
        return numbers.contains(bonusNumebr)
    }
}
