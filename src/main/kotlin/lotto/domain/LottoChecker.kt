package lotto.domain

class LottoChecker {
    fun countCorrectNumbers(numbers: List<Int>, winningNumbers: List<Int>): Int {
        return numbers.filter { number -> winningNumbers.contains(number) }.size
    }

    fun hasBonusNumber(numbers: List<Int>, bonusNumber: Int): Boolean {
        return false
    }
}