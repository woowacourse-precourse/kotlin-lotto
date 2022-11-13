package lotto

class WinningCalculator() {

    private val winningList = mutableListOf<Int>(0, 0, 0, 0, 0, 0)

    fun getResult(lottoNumbers: List<List<Int>>, winningNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
        for (i in lottoNumbers.indices) {
            val lotto = Lotto(lottoNumbers[i])
            val winningResult = lotto.compareWinningNumber(winningNumber)
            val bonusResult = lotto.compareBonusNumber(bonusNumber)

            getWinningList(winningResult, bonusResult)
        }
        return winningList
    }

    private fun getWinningList(winningResult: Int, bonusResult: Boolean) {
        when (winningResult) {
            3 -> winningList[5]++
            4 -> winningList[4]++
            5 -> if (bonusResult) winningList[2]++ else winningList[3]++
            6 -> winningList[1]++
            else -> winningList[0]++
        }
    }
}