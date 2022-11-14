package lotto

import camp.nextstep.edu.missionutils.Randoms

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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun getWinningResult(winningNumber: List<String>, bonus: String): MutableList<Int> {
        val winningResult = mutableListOf(0, 0, 0, 0, 0) // winningResult  = 5등, 4등, 3등, 2등, 1등
        lotteryTickets.forEach {
            val winning = it.compareWinningNumber(winningNumber, bonus)
            if (winning in 0..4) {
                winningResult[winning]++
            }
        }
        return winningResult
    }

    fun getAllLottoNumber(): List<String> {
        return lotteryTickets.map { it.getNumber() }
    }
}