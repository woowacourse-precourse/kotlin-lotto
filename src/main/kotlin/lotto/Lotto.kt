package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {

    class Lotto(private val numbers: List<Int>) {

        init {
            require(numbers.size == 6)
        }

        fun contains(number: Int): Boolean {
            if (numbers.contains(number)) {
                return true
            }
            return false
        }

        fun getValue(index: Int): Int {
            return numbers[index]
        }

        fun getNumbers(): List<Int> {
            return numbers
        }
    }
    // TODO: 추가 기능 구현
}


