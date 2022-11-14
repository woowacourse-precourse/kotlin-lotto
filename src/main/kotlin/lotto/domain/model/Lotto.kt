package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.controller.LottoController.Companion.ERROR_MESSAGE
import lotto.domain.model.Prize.*

class Lotto(private val numbers: List<Int>) {
    init {
        checkValidation()
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun contains(number: Int) = numbers.contains(number)

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
        val correctCnt = numbers.count { winningNum.contains(it) }
        return when (Prize.create(correctCnt)) {
            CORRECT_THREE -> 5_000
            CORRECT_FOUR -> 50_000
            CORRECT_FIVE -> if (numbers.contains(bonusNum)) 30_000_000 else 1_500_000
            CORRECT_SIX -> 2_000_000_000
        }
    }

    companion object {

        const val LOTTO_PRIZE = 1000
        fun newInstance(): Lotto {
            return Lotto(makeRandomNum())
        }

        private fun makeRandomNum(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}
