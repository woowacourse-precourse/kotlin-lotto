package lotto

import camp.nextstep.edu.missionutils.Randoms
import data.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private val numberHashMap: HashMap<Int, List<Int>> = HashMap()

    fun createNumber(): List<Int> {
        val purchase = Purchase()
        val expense = purchase.createExpense()
        val lottoQuantity = purchase.updateLottoQuantity(expense)
        println("\n${lottoQuantity}" + StringResource.TICKETS.resource)

        for (item in 0 until lottoQuantity) {
            val numberList = Randoms.pickUniqueNumbersInRange(START_NUMBER_ONE, END_NUMBER_FORTY_FIVE, numbers.size)
            numberHashMap[item] = numberList.sorted()
        }
        updateNumberList()
        val winningNumber = createWinningNumber()
        val bonusNumber = createBonusNumber()

        return createMatchCountList(winningNumber, bonusNumber)
    }


    private fun updateNumberList() {
        numberHashMap.forEach { (_, value) -> println(value) }
    }


    private fun createMatchCountList(winningNumber: List<Int>, bonusNumber: Int): List<Int> {
        return numberHashMap.map { (_, value) ->
            updateMatchCount(value, winningNumber, bonusNumber)
        }
    }


    fun checkNumber() {
        numbers.forEach { number ->
            when (number) {
                in START_NUMBER_ONE..END_NUMBER_FORTY_FIVE -> number
                else -> throw IllegalArgumentException(StringResource.INVALID.resource)
            }
        }
    }

    private fun createWinningNumber(): List<Int> {
        println(StringResource.WINNING.resource)
        val winningNumberList = readLine()!!.split(",")
        return winningNumberList.map { winningNumber ->
            winningNumber.toInt()
        }

    }

    private fun createBonusNumber(): Int {
        println(StringResource.BONUS.resource)
        return readLine()!!.toInt()
    }
    
    fun updateMatchCount(userNumber: List<Int>, winningNumber: List<Int>, bonusNumber: Int): Int {
        var count = NONE_MATCH
        for (item in userNumber.indices) {
            if (winningNumber.contains(userNumber[item])) count++
        }
        if (count == FIVE_MATCH && userNumber.contains(bonusNumber)) count += TWO
        return count
    }
}

