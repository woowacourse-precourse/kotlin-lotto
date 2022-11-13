package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

val LOTTO_SIZE = 6

class Seller {
    fun generateLotto(LottoCnt: Int) {
        println("\n${LottoCnt}개를 구입했습니다.")
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE).sorted()
            println(randLotto)
        }
    }

    fun getWinningNumber() {
        var judgment = Judgment()
        var winningNumber = mutableListOf<Int>()

        println("\n당첨 번호를 입력해 주세요.")
        var winningLottoNumber = Console.readLine()
        winningLottoNumber.split(",").forEach() {
            it.toIntOrNull()?.let { it -> winningNumber.add(it) }
        }
        if (judgment.checkWinningNumber(winningNumber)) {
            getBonusNumber()
        }
    }

    fun getBonusNumber() {
        var judgment = Judgment()

        println("\n보너스 번호를 입력해 주세요.")
        var bonusNumber = Console.readLine()
        judgment.checkBonusNumber(bonusNumber)
    }
}