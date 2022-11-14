package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkWinningNumbersMatching(winningNumbers: List<Int>): Int {
        return numbers.filter { winningNumbers.contains(it) }.size
    }

    fun checkBonusNumberMatching(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun printNumbers() {
        println(numbers)
    }
}
