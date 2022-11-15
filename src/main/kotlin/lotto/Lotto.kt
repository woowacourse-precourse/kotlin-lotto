package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct() == numbers)
        numbers.forEach { n ->
            require(n in 1..45)
        }
    }
    fun calculateWinningResult(lottoNumbersList: MutableList<List<Int>>, winningNumbers: List<Int>, bonusNumber: String): MutableList<Int> {
        val winningResult: MutableList<Int> = mutableListOf(0,0,0,0,0)
        for (i in lottoNumbersList.indices) {
            when (Winning().getCountOfMatchWinning(lottoNumbersList[i], winningNumbers)) {
                3 -> { winningResult[0] += 1 }
                4 -> { winningResult[1] += 1 }
                5 -> { winningResult[2] += 1 }
                6 -> {winningResult[4] += 1 }
            }
            if(Winning().getCountOfMatchWinning(lottoNumbersList[i], winningNumbers) == 5 && Winning().getCountOfMatchBonus(lottoNumbersList[i],bonusNumber)){
                winningResult[3] += 1
            }
        }
        return winningResult
    }
}
