package lotto.model

import lotto.util.Constant.FIFTH_BONUS

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun countMatchNumber(winningLotto: WinningLotto): String {
        val count = numbers.size - (winningLotto.number - numbers).size
        if (count == 5) {
            if (isBonusCorrect(winningLotto.bonus)) {
                return FIFTH_BONUS
            }
        }
        return count.toString()
    }

    fun isBonusCorrect(bonus: Int): Boolean = bonus in numbers

}
