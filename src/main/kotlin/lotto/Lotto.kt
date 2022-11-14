package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        checkValidation()
    }

    private fun checkValidation() {
        require(numbers.size == 6) {
            "$ERROR_MESSAGE 로또의 길이는 6이여야 합니다."
        }
        require(numbers.distinct().size == 6) {
            "$ERROR_MESSAGE 중복된 숫자가 없어야 합니다."
        }
        numbers.forEach { number ->
            require(number in 1..45) {
                "$ERROR_MESSAGE 중복된 숫자가 없어야 합니다."
            }
        }
    }

    fun getPrize(winningNum: List<Int>, bonusNum: Int): Int {

    }


    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
        fun newInstance(): Lotto {
            return Lotto(makeRandomNum())
        }

        private fun makeRandomNum(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
