package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Message.Companion.DUPLICATED_NUMBERS_MESSAGE
import lotto.Message.Companion.NUMBER_IS_DUPLICATED_MESSAGE
import lotto.Message.Companion.UNIT_DELIMETER
import lotto.Units.Companion.ADDED_BONUS_NUMBER
import lotto.Units.Companion.BONUS_REWARD
import lotto.Units.Companion.INIT_ARRAY
import lotto.Units.Companion.INIT_NUMBER
import lotto.Units.Companion.LOTTO_SIZE
import lotto.Units.Companion.THOUSAND_UNIT

class Broadcast() {
    private var winningNumbers = listOf<Int>()
    private val winLottery = Array(INIT_ARRAY) { INIT_NUMBER }.toMutableList()
    private var bonusNumber = INIT_NUMBER
    private var bonusCount = INIT_NUMBER

    fun broadcast(lottery: List<List<Int>>) {
        printPutinWinningNumber()
        winningNumbers = winningLotto()
        printPutInBonusNumber()
        bonusNumber = winningBonusLotto()
        winLotto(lottery)
        bonusCount = bonusWinningNumber(lottery, bonusNumber)
        winLottery[ADDED_BONUS_NUMBER] = winLottery[ADDED_BONUS_NUMBER] - bonusCount
        statistics(winLottery, bonusCount)
        profits(winLottery, bonusCount)
    }


    private fun winningLotto(): List<Int> {
        val numbers = Console.readLine()
            .split(UNIT_DELIMETER)
            .map { it.toInt() }
            .toList()
        inputWinningNumbersCheck(numbers)
        return numbers
    }

    private fun winningBonusLotto(): Int {
        val bonus = Console.readLine()
            .toInt()
        inputNumberDuplicatedCheck(bonus)
        return bonus
    }

    private fun winLotto(lottery: List<List<Int>>): List<Int> {
        for (ticket in lottery) {
            val count = makeWinningNumber(ticket)
            winLottery[count]++
        }
        return winLottery
    }

    private fun bonusWinningNumber(lotterys: List<List<Int>>, bonusNumber: Int): Int {
        var bonusCounter = INIT_NUMBER
        for (lottery in lotterys) {
            val counter = makeWinningNumber(lottery)
            if (counter == ADDED_BONUS_NUMBER) {
                if (lottery.contains(bonusNumber)) bonusCounter++
            }
        }
        return bonusCounter
    }

    private fun makeWinningNumber(lottery: List<Int>): Int {
        var winningNumberCounter = INIT_NUMBER
        winningNumbers.forEach {
            if (lottery.contains(it)) winningNumberCounter++
        }
        return winningNumberCounter
    }

    private fun statistics(winningNumber: List<Int>, bonusNumber: Int) {
        printStatistics()
        printRewards(winningNumber, bonusNumber)
    }

    fun profits(winLottery: List<Int>, bonusNumber: Int) {
        val sales = winLottery.sum() * THOUSAND_UNIT
        var reward = INIT_NUMBER
        for (count in INIT_NUMBER..LOTTO_SIZE) {
            reward += winLottery[count] * rank(count)
        }
        reward += bonusNumber * BONUS_REWARD
        printProfit(reward, sales)
    }

    private fun rank(count: Int): Int {
        return when (count) {
            Rank.FIRST.ranking -> Rank.FIRST.reward
            Rank.SECOND.ranking -> Rank.SECOND.reward
            Rank.THIRD.ranking -> Rank.THIRD.reward
            Rank.FOURTH.ranking -> Rank.FOURTH.reward
            else -> INIT_NUMBER
        }
    }

    private fun inputWinningNumbersCheck(numbers: List<Int>) {
        if (numbers.size != LOTTO_SIZE) throw IllegalArgumentException(DUPLICATED_NUMBERS_MESSAGE)
    }

    private fun inputNumberDuplicatedCheck(bonus: Int) {
        if (winningNumbers.contains(bonus)) throw IllegalArgumentException(NUMBER_IS_DUPLICATED_MESSAGE)
    }
}
