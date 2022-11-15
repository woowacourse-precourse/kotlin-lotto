package winning

import util.Constants
import util.Game
import util.Error

class WinningNumberInput {
    fun getWinningNumber(): List<Int> {
        println(Game.WINNING_NUMBER_INPUT.message)
        val input = readLine()?.split(Game.SPLIT.message)

        WinningNumber(input)

        return WinningNumber(input).changeIntToList()
    }
}