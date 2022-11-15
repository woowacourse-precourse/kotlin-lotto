package winning

import util.Game

class WinningNumberInput {
    fun getWinningNumber(): List<Int> {
        println(Game.WINNING_NUMBER_INPUT.message)
        val input = readLine()?.split(Game.SPLIT.message)

        return WinningNumberChecker(input).changeIntToList()
    }
}