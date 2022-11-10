package lotto

import lotto.Constant.Companion.lottoSize

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == lottoSize)
    }
    fun getNumbers(): List<Int> {
        return numbers
    }

    fun findWinning(numbers: List<Int>, winningNumber: List<Int>, bonusNumber: Int): Reward {
        var bonus: Boolean = false
        var winningCount = 0

        for (number in numbers) {
            if (winningNumber.contains(number)) winningCount += 1
            if (number == bonusNumber) bonus = true
        }
        return getReward(winningCount, bonus)
    }

    fun getReward(winningCount: Int, bonus: Boolean): Reward {
        when (winningCount) {
            Reward.FIRST.winningCount -> return Reward.FIRST
            Reward.FOURTH.winningCount -> return Reward.FOURTH
            Reward.FIFTH.winningCount -> return Reward.FIFTH
        }
        if (winningCount == Reward.THIRD.winningCount && !bonus) return Reward.THIRD
        if (winningCount == Reward.SECOND.winningCount && bonus) return Reward.SECOND
        return Reward.MISS
    }

}
