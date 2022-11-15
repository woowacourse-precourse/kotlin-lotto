package lotto

import camp.nextstep.edu.missionutils.Randoms

const val MIN_VALUE = 1
const val MAX_VALUE = 45
const val LOTTO_SIZE = 6
const val FIRST_PLACE = 4
const val FIFTH_PLACE = 0
class LottoList {
    private var lotteryTickets = mutableListOf<Lotto>()

    fun repeatAddition(num: Int) {
        for (i in 1..num) {
            addLotto()
        }
    }

    private fun addLotto() {
        lotteryTickets.add(Lotto(generateLottoNumber()))
    }

    private fun generateLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_SIZE).sorted()
    }

    fun getWinningResult(winningNumber: List<String>, bonus: String): MutableList<Int> {
        val winningResult = mutableListOf(0, 0, 0, 0, 0) // winningResult  = (5등, 4등, 3등, 2등, 1등)
        lotteryTickets.forEach {
            val winning = it.compareWinningNumber(winningNumber, bonus)
            if (winning in FIFTH_PLACE..FIRST_PLACE) {
                winningResult[winning]++
            }
        }
        return winningResult
    }

    fun getAllLottoNumber(): List<String> {
        return lotteryTickets.map { it.getNumber() }
    }
}
