package lotto

class SelectionWinning {

    fun getWinCount(publishNums: List<Int>, winNums: List<Int>): Int {
        var winCount = 0
        val commonNums = publishNums.filter { it in winNums.map { item -> item } }
        winCount = commonNums.size
        return winCount
    }

    fun getBonusCount(publishNums: List<Int>, winNums: List<Int>, bonusNums: Int): Boolean {
        var isBonusWin = false
        if (getWinCount(publishNums, winNums) == 5) {
            isBonusWin = publishNums.any { it == bonusNums }
        }
        return isBonusWin
    }

    fun getWinningWithoutBonus(
        totalPublishNums: List<List<Int>>, winNums: List<Int>,
    ): List<Int> {
        val winCountWithoutBonus = mutableListOf<Int>()
        for (i in 0 until totalPublishNums.size) {
            when (getWinCount(totalPublishNums[i], winNums)) {
                3 -> winCountWithoutBonus.add(Prize.valueOf("FIFTH").prize)
                4 -> winCountWithoutBonus.add(Prize.valueOf("FOURTH").prize)
                5 -> winCountWithoutBonus.add(Prize.valueOf("THIRD").prize)
                6 -> winCountWithoutBonus.add(Prize.valueOf("FIRST").prize)
            }
        }
        return winCountWithoutBonus
    }

    fun getWinningListTotal(
        totalPublishNums: List<List<Int>>, winNums: List<Int>, bonusNums: Int
    ): List<Int> {
        val totalWinCount = mutableListOf<Int>()
        for (i in 0 until totalPublishNums.size) {
            if (getBonusCount(totalPublishNums[i], winNums, bonusNums)) {
                totalWinCount.add(Prize.valueOf("SECOND").prize)
            } else if (!getBonusCount(totalPublishNums[i], winNums, bonusNums)) {
                totalWinCount += getWinningWithoutBonus(totalPublishNums, winNums)
            }
        }
        return totalWinCount
    }
}