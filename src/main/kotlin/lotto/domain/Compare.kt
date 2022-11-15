package lotto.domain

class Compare {
    fun checkWinningNumbers(win: List<Int>, lotto: List<Int>): Int {
        var count = 0
        for (index in lotto.indices) {
            if (lotto[index] in win) {
                count++
            }
        }
        return count
    }

    fun checkBonusNumber(bonus: Int, lotto: List<Int>): Boolean {
        if (bonus in lotto)
            return true
        return false
    }
}