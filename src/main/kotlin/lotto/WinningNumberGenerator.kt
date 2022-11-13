package lotto

object WinningNumberGenerator {
    fun generateWinningNumber(winningNumber: List<String>): List<Int> = winningNumber.map { it.toInt() }
    fun generateBonusNumber(bonusNumber: String): Int = bonusNumber.toInt()
}