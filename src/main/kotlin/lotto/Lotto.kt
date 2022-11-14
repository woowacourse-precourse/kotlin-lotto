package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            Error.sizeError()
        }
        require(numbers.distinct().size == 6) {
            Error.overlapError()
        }
    }
    fun printLotto() {
        println(numbers)
    }

    fun matchLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningType {
        var hit = 0
        for(i in 0..5) {
            if (numbers.contains(winningNumbers[i])) hit += 1
        }
        return when(hit) {
            6 -> WinningType.FIRST
            5 -> if(numbers.contains(bonusNumber)) {
                WinningType.SECOND
            } else {
                WinningType.THIRD
            }
            4 -> WinningType.FOURTH
            3 -> WinningType.FIFTH
            else -> WinningType.NOTHING
        }
    }
}