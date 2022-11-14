package lotto

import Util.Game

class ProfitPrinter {
    fun printProfit(rateOfProfit: Double) {
        val rate = String.format(Game.RATE_OF_PROFIT_FORMAT.message, rateOfProfit)
        println(Game.RATE_OF_PROFIT_OUTPUT1.message + rate + Game.RATE_OF_PROFIT_OUTPUT2.message)
    }
}