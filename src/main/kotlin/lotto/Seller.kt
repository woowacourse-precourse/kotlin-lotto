package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import lotto.Constant.Companion.BONUS_NUMBER
import lotto.Constant.Companion.BUY_LOTTO
import lotto.Constant.Companion.LOTTO_SIZE
import lotto.Constant.Companion.WINNING_LOTTO

class Seller {
    var judgment = Judgment()

    fun generateLotto(LottoCnt: Int) {
        println("${LottoCnt}${BUY_LOTTO}")
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE).sorted()
            println(randLotto)
            allRandomRotto.add(randLotto)
        }
    }

    fun getWinningNumber() {
        println("$WINNING_LOTTO")
        var winningLottoNumber = Console.readLine()
        winningLottoNumber.split(",").forEach() {
            it.toIntOrNull()?.let { winningNumber.add(it) }
        }
        winningNumber.sort()
        if (judgment.checkWinningNumber(winningNumber)) {
            getBonusNumber()
        }
    }

    fun getBonusNumber() {
        println("$BONUS_NUMBER")
        bonusNumber = Console.readLine()
        judgment.checkBonusNumber(bonusNumber, winningNumber)
    }
    companion object {
        var winningNumber = mutableListOf<Int>()
        var bonusNumber = ""
        var allRandomRotto = mutableListOf<List<Int>>()
    }
}

