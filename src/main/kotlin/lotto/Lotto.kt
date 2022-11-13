package lotto
const val NOTHING = -1
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        Exceptions.checkLotto(numbers)
    }
    enum class WinningGroup(val same: Int, val Winning: Int) {
        FirstPlace(6, 4),
        SecondPlace(-1, 3),
        ThirdPlace(5, 2),
        FourthPlace(4, 1),
        FifthPlace(3, 0),
    }

    fun getNumber():String{
        return numbers.toString()
    }

    fun checkWinning(winningNumber: List<String>, bonus : String): Int {
        val winning = numbers.count {
            winningNumber
                .contains(it.toString())
        }
        if (winning == 5) {
            if (bonus.contentEquals(numbers.toString()))
                return WinningGroup.SecondPlace.Winning
        }
        return WinningGroup.values().find { it.same==winning }?.Winning ?: return NOTHING
    }

}
