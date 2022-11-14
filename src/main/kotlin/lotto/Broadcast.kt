package lotto

import camp.nextstep.edu.missionutils.Console

class Broadcast() {
    var winningNumbers = listOf<Int>()
    var bonusNumber = 0
    val winLottery = mutableListOf(0, 0, 0, 0, 0, 0, 0)
    var bonusCount = 0

    fun broadcast(lottery: List<List<Int>>) {
        println()
        println("당첨 번호를 입력해 주세요.")
        winningNumbers = winningLotto()
        println()
        println("보너스 번호를 입력해주세요.")
        bonusNumber = winningBonusLotto()
        winLotto(lottery)
        bonusCount = bonusWinningNumber(lottery, bonusNumber)
        winLottery[5] = winLottery[5] - bonusCount
        statistics(winLottery, bonusCount)
        profits(winLottery, bonusCount)
    }

    private fun winningLotto(): List<Int> {
        val numbers = Console.readLine()
            .split(",")
            .map { it.toInt() }
            .toList()
        if (numbers.size != 6) throw IllegalArgumentException("[ERROR] 숫자가 6개가 아닙니다.")
        return numbers
    }

    private fun winningBonusLotto(): Int {
        val bonus = Console.readLine()
            .toInt()
        if (winningNumbers.contains(bonus)) throw IllegalArgumentException("[ERROR] 당첨된 번호와 보너스번호가 중복입니다.")
        return bonus
    }

    fun winLotto(lottery: List<List<Int>>): List<Int> {
        for (ticket in lottery) {
            var count = 0
            count = makeWinningNumber(ticket)
            winLottery[count]++
        }
        return winLottery
    }

    fun bonusWinningNumber(lotterys: List<List<Int>>, bonusNumber: Int): Int {
        var bonusCounter = 0
        var counter = 0
        for (lottery in lotterys) {
            counter = makeWinningNumber(lottery)
            if (counter == 5) {
                if (lottery.contains(bonusNumber)) bonusCounter++
            }
        }
        return bonusCounter
    }

    private fun makeWinningNumber(lottery: List<Int>): Int {
        var winningNumberCounter = 0
        winningNumbers.forEach {
            if (lottery.contains(it)) winningNumberCounter++
        }
        return winningNumberCounter
    }

    fun statistics(winningNumber: List<Int>, bonusNumber: Int) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winningNumber[3]}개")
        println("4개 일치 (50,000원) - ${winningNumber[4]}개")
        println("5개 일치 (1,500,000원) - ${winningNumber[5]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${bonusNumber}개")
        println("6개 일치 (2,000,000,000원) - ${winningNumber[6]}개")
    }

    fun profits(winLottery: List<Int>, bonusNumber: Int) {
        var sales = winLottery.sum() * 1000
        var list = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
        var prize = 0
        for (i in 0..6) {
            prize += winLottery[i] * list[i]
        }
        prize += bonusNumber * 30000000
        var profit = "%.1f".format(prize.toDouble() / sales * 100)
        println("총 수익률은 ${profit}%입니다.")
    }
}
