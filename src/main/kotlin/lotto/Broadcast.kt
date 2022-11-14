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

}
