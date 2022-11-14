package lotto.domain

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == numbers.size)
        require(bonusNumber !in numbers)
    }

    fun numbers() = numbers

    fun bonusNumber() = bonusNumber

    fun winningResult(lotto: Lotto): WinningResult {
        return WinningResult.FIRST
    }
}