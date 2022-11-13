package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private val numberHashMap: HashMap<Int, List<Int>> = HashMap()

    fun createNumber(): List<Int> {
        val purchase = Purchase()
        val lottoQuantity = purchase.createExpense()
        val winningNumber = createWinningNumber()
        val bonusNumber = createBonusNumber()

        for (item in 0 until lottoQuantity) {
            val numberList = Randoms.pickUniqueNumbersInRange(START_NUMBER_ONE, END_NUMBER_FORTY_FIVE, numbers.size)
            numberHashMap[item] = numberList.sorted()
        }
        updateNumberList()

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
                else -> throw IllegalArgumentException("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    private fun createWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요")
        val winningNumberList = readLine()!!.split(",")
        return winningNumberList.map { winningNumber ->
            winningNumber.toInt()
        }

    }

    private fun createBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요")
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

const val START_NUMBER_ONE = 1
const val END_NUMBER_FORTY_FIVE = 45

const val NONE_MATCH = 0
const val FIVE_MATCH = 5
const val TWO = 2