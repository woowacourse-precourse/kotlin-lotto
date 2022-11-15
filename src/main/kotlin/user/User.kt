package user

import util.Constants
import util.Game
import util.Error

class User {
    fun getMoney(): Int {
        println(Game.USER_INPUT.message)
        val input = readLine()

        Money(input)

        return input?.toInt() ?: Constants.ZERO.constant
    }
}