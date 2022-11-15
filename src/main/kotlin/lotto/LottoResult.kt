package lotto

class LottoResult {
    fun getWinningResult(winningNumber: List<Int>): List<Int> {
        val winningResult = mutableListOf(0, 0, 0, 0, 0)

        Lotto.lotteries.forEach {
            val checkCount = checkEqualNumber(winningNumber, it)
            val rank = checkWinningRank(checkCount)
            if (rank in 0..5) {
                winningResult[rank] += 1
            }
        }

        return winningResult
    }


    private fun checkWinningRank(count: List<Int>): Int {
        return when (count[0]) {
            3 -> 5
            4 -> 4
            5 -> if (count[1] == 1) 2 else 3
            6 -> 1
            else -> 0
        }
    }


    private fun checkEqualNumber(winningNumber: List<Int>, lottoNumber: List<Int>): List<Int> {
        val count = mutableListOf(0, 0)

        for (index in 0 until winningNumber.size - 1) {
            if (lottoNumber.contains(winningNumber[index]))
                count[0] += 1
        }

        if (count[0] == 5 && lottoNumber.contains(winningNumber.last()))
            count[1] += 1

        return count
    }
}