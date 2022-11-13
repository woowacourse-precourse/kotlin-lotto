package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compareWinningNumber(winningNumber: List<Int>): Int {
        var result = 0
        winningNumber.forEach { n ->
            if (numbers.contains(n)) result++
        }
        return result
    }

    fun compareBonusNumber(bonusNumber: Int): Boolean {
        if (numbers.contains(bonusNumber)) return true
        return false
    }
}
