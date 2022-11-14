package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            println(ERROR_LENGTH)
        }
        require(notDuplicate(numbers)) {
            println(ERROR_DUPLICATE)
        }
        require(inRange(numbers)) {
            println(ERROR_OUT_RANGE)
        }
        lottos.add(numbers.sorted())
    }

    private fun notDuplicate(numbers: List<Int>): Boolean {
        return numbers.size == numbers.distinct().count()
    }

    private fun inRange(numbers: List<Int>): Boolean {
        return numbers.all { it in MIN until MAX + 1 }
    }

    companion object {
        const val ERROR_LENGTH = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야합니다."
        const val ERROR_DUPLICATE = "[ERROR] 로또 번호는 서로 중복돼서는 안됩니다."
        const val ERROR_OUT_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."

        val lottos = mutableListOf<List<Int>>()

        fun printCount() {
            println("\n${lottos.size}개를 구매했습니다.")
            for (lotto in lottos) {
                println(lotto)
            }
        }

        fun publish(purchaseCount: Int) {
            for (count in 1..purchaseCount) {
                val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                Lotto(numbers)
            }
        }
    }
}

