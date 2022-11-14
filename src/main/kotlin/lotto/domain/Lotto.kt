package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == numbers.size)
    }

    fun numbers() = numbers

    fun winningResult(winningNumbers: List<Int>, bonusNumber: Int): WinningResult {
        return WinningResult.FIRST
    }
}
