package lotto.domain

import lotto.*

class LottoWin(val purchase: List<Lotto>, val userGamePrizeNumber: Lotto, val bonusNumber: Int) {

    fun findLottoWin(): MutableList<Int> {
        val resultLotto = mutableListOf(0, 0, 0, 0, 0)
        for (i in purchase) {
            val now = checkRepeatLotto(i, userGamePrizeNumber)
            if (now < 0)
                continue
            resultLotto[now]++
        }
        printLottoWin(resultLotto)
        return resultLotto
    }

    fun checkRepeatLotto(purchaseNumber: Lotto, userGamePrizeNumber: Lotto): Int {
        val winCount = userGamePrizeNumber.getNumbersSize() - userGamePrizeNumber.getNumbers().toSet()
            .minus(purchaseNumber.getNumbers().toSet()).size
        if ((winCount == 5 && checkBonusLotto(purchaseNumber, bonusNumber) != null) || winCount == 6)
            return winCount - 2
        return winCount - 3
    }


    fun checkBonusLotto(purchaseNumber: Lotto, bonusNumber: Int) =
        purchaseNumber.getNumbers().find { it == bonusNumber }

    fun printLottoWin(resultLotto: MutableList<Int>) {
        println(RESULT_MESSAGE)
        println(DIVIDE_LINE)
        println(LOTTO_WIN_THREE + resultLotto[0] + NUMBER_THING)
        println(LOTTO_WIN_FOUR + resultLotto[1] + NUMBER_THING)
        println(LOTTO_WIN_FIVE + resultLotto[2] + NUMBER_THING)
        println(LOTTO_WIN_FIVE_BONUS + resultLotto[3] + NUMBER_THING)
        println(LOTTO_WIN_SIX + resultLotto[4] + NUMBER_THING)
    }

}