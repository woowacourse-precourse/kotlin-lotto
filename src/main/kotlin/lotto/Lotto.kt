package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun createNumber() {
        val purchase = Purchase()
        val lottoQuantity = purchase.createExpense()
        for (index in 0 until lottoQuantity) {
            val numberList = Randoms.pickUniqueNumbersInRange(1, 45, numbers.size)
            println(numberList.sorted())
        }

    }

    fun checkNumber() {
        numbers.forEach { number ->
            when (number) {
                in 1..45 -> number
                else -> throw IllegalArgumentException("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun createWinningNumber(): List<Int> {
        val winningNumber = Randoms.pickUniqueNumbersInRange(1,45, 6)
        return winningNumber.sorted()
    }

}
