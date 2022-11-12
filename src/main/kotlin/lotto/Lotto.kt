package lotto

import camp.nextstep.edu.missionutils.Randoms

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
}
