package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkNumberDuplicate()
    }

    private fun checkNumberDuplicate() {
        for (i in 0..4) {
            for (j in i + 1..5) {
                if (numbers[i] == numbers[j]) {
                    throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
                }
            }
        }
    }

    fun calculateLottoWin(
        lottoCount: Int,
        allLotto: Array<IntArray>,
        bonusNum: Int,
    ): MutableList<Int> {
        var bonusCount = 0
        var winningCounts = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0)

        for (i in 0 until lottoCount) {
            val lottos = allLotto[i].toList()
            var answerCount = 0
            for (j in 0..5) {
                answerCount = compareWithLottoNum(lottos[j], bonusNum, answerCount)[0]
                bonusCount = compareWithLottoNum(lottos[j], bonusNum, answerCount)[1]
            }
            winningCounts = addWinningCounts(answerCount, winningCounts)
            winningCounts = addWinningBonusCounts(answerCount, bonusCount, winningCounts)
        }

        return winningCounts
    }

    private fun compareWithLottoNum(lottoNum: Int, bonusNum: Int, answerCount: Int): List<Int> {
        var answerCount = answerCount
        var bonusCount = 0

        for (k in 0..5) {
            if (winnings[k].toInt() == lottoNum) {
                answerCount++
            }
            if (bonusNum == lottoNum) {
                bonusCount = 1
            }
        }
        return (listOf(answerCount, bonusCount))
    }

    private fun addWinningCounts(answerCount: Int, winningCounts: MutableList<Int>): MutableList<Int> {
        if (answerCount != 0) {
            winningCounts[answerCount] = winningCounts[answerCount] + 1
        }
        return winningCounts
    }

    private fun addWinningBonusCounts(
        answerCount: Int,
        bonusCount: Int,
        winningCounts: MutableList<Int>,
    ): MutableList<Int> {
        if (answerCount == 5 && bonusCount == 1) {
            winningCounts[7] = winningCounts[7] + 1
        }
        return winningCounts
    }
}
