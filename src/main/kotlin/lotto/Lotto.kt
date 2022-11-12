package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printLottoNumber(): List<Int> {
        return numbers
    }

    fun compareWithWinningNumber(winningNumber: List<Int>): Int {
        var count = 0
        for (i in winningNumber) {
            if (numbers.contains(i))
                count++
        }
        return count
    }

    fun determineRank(count : Int, bonusNumber: Int): Any {
        when (count) {
            6 -> return Rank.First.rank
            5 -> {
                if (numbers.contains(bonusNumber))
                    return Rank.Second.rank
                return Rank.Third.rank
            }
            4 -> return Rank.Fourth.rank
            3 -> return Rank.Fifth.rank
            else -> return Rank.None.rank
        }
    }
}
