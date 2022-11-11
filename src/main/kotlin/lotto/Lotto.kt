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
        var isBonusNumberHit = false
        for(i in 0..5) {
            if (winningNumbers[i] == numbers[i]) hit += 1
        }
        if(hit == 5) {
            isBonusNumberHit = numbers.contains(bonusNumber)
        }

        return when(hit) {
            6 -> WinningType.FIRST
            5 -> if(isBonusNumberHit) {
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