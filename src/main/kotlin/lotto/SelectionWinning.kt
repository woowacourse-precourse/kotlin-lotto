package lotto

class SelectionWinning{

    //6-1. 당첨 숫자를 게산하는 함수 생성
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

    fun getWinningListTotal(
        lottoCount: Int,
        totalPublishNums: List<List<Int>>,
        winNums: List<Int>,
        bonusNums: Int
    ): List<String> {
        val totalWinCount = mutableListOf<String>()
        for (i in 0..lottoCount) {
            if (getBonusCount(totalPublishNums[i], winNums, bonusNums)) {
                totalWinCount.add(Prize.valueOf("SECOND").prize)
            } else if (!getBonusCount(totalPublishNums[i], winNums, bonusNums)) {
                totalWinCount += getWinningWithoutBonus(lottoCount, totalPublishNums, winNums)
            }
        }
        return totalWinCount
    }

    fun getWinningWithoutBonus(
        lottoCount: Int,
        totalPublishNums: List<List<Int>>,
        winNums: List<Int>,
    ): List<String> {
        val winCountWithoutBonus = mutableListOf<String>()
        for (i in 0..lottoCount) {
            when (getWinCount(totalPublishNums[i], winNums)) {
                3 -> winCountWithoutBonus.add(Prize.valueOf("FIFTH").prize)
                4 -> winCountWithoutBonus.add(Prize.valueOf("FOURTH").prize)
                5 -> winCountWithoutBonus.add(Prize.valueOf("THIRD").prize)
                6 -> winCountWithoutBonus.add(Prize.valueOf("FIRST").prize)
            }
        }
        return winCountWithoutBonus
    }

}