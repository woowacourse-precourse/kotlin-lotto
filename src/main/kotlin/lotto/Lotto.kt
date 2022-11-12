package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printLottoNumber(): List<Int> {
        return numbers
    }

    fun compareWithWinningNumber(winningNumber: List<Int>, bonusNumber: Int): Int {
        var count = 0
        for (i in winningNumber) {
            if (numbers.contains(i))
                count++
        }
        when (count) {
            6 -> return 1
            5 -> {
                if (numbers.contains(bonusNumber)) return 2
                return 3
            }
            4 -> return 4
            3 -> return 5
            else -> return 0
        }
    }
}
