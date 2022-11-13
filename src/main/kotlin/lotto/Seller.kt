package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class Seller {
    var judgment = Judgment()
    var winningNumber = mutableListOf<Int>()
    var bonusNumber = ""

    fun generateLotto(LottoCnt: Int) {
        println("\n${LottoCnt}개를 구입했습니다.")
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE).sorted()
            println(randLotto)
        }
        getWinningNumber()
    }

    fun getWinningNumber() {
        println("\n당첨 번호를 입력해 주세요.")
        var winningLottoNumber = Console.readLine()
        winningLottoNumber.split(",").forEach() {
            it.toIntOrNull()?.let { it -> winningNumber.add(it) }
        }
        winningNumber.sort()
        if (judgment.checkWinningNumber(winningNumber)) {
            getBonusNumber()
        }
    }

    fun getBonusNumber() {
        println("\n보너스 번호를 입력해 주세요.")
        bonusNumber = Console.readLine()
        if (judgment.checkBonusNumber(bonusNumber)) {
            println("보너스 번호 입력 성공")
        }
    }
}