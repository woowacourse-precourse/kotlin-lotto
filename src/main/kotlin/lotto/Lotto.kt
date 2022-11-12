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
            6 -> return Rank.First
            5 -> {
                if (numbers.contains(bonusNumber))
                    return Rank.Second
                return Rank.Third
            }
            4 -> return Rank.Fourth
            3 -> return Rank.Fifth
            else -> return Rank.None
        }
    }
}
