package lotto

import camp.nextstep.edu.missionutils.Console

class Money {
    var money: String = ""
    fun inputMoney() {
        try {
            money = Console.readLine()
            Exceptions.checkMoney(money)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 입력 금액이 올바르지 않습니다.")
            money = "ERROR"
        }
    }

    fun countLotteryTickets(): Int {
        return money.toInt() / 1000
    }

    fun getProfitRate(winningResult: List<Int>): Double {
        val prize = getPrize(winningResult)
        return roundOff(calculateProfitRate(prize))
    }

    private fun getPrize(winningResult: List<Int>): Int {
        val winMoney = listOf(5000, 50000, 1500000, 30000000, 2000000000)
        var prize = 0
        winningResult.forEachIndexed { index, it -> prize += winMoney[index] * it }

        return prize
    }

    private fun calculateProfitRate(prize: Int): Double {
        return (prize / money.toDouble() * 100)
    }


    private fun roundOff(d: Double): Double {
        return String.format("%.2f", d).toDouble()
    }
}