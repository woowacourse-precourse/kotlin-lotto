package winning

import util.Constants
import util.Game
import util.Error

class BonusNumberInput {
    fun getBonusNumber(winningNumber: List<Int>): Int {
        println(Game.BONUS_NUMBER_INPUT.message)
        val input = readLine()

        return BonusNumberChecker(input, winningNumber).changeInputToInt()
    }
}