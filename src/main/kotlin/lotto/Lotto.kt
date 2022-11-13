package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun createNumber() {
        val purchase = Purchase()
        val lottoQuantity = purchase.createExpense()
        for (item in 0 until lottoQuantity) {
            val numberList = Randoms.pickUniqueNumbersInRange(START_NUMBER_ONE,
                END_NUMBER_FORTY_FIVE,
                numbers.size)
            println(numberList.sorted())

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

    fun createWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요")
        val winningNumberList = readLine()!!.split(",")
        return winningNumberList.map { winningNumber ->
            winningNumber.toInt()
        }
    }

    fun createBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요")
        return readLine()!!.toInt()
    }

}

const val START_NUMBER_ONE = 1
const val END_NUMBER_FORTY_FIVE = 45