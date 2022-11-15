package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constant

class LottoMaker {
    companion object {
        var winningNumber = listOf<Int>()
        var bonusNumber = ""
        var allRandomRotto = mutableListOf<List<Int>>()
    }

    fun generateLotto(LottoCnt: Int) {
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, Constant.LOTTO_SIZE).sorted()
            println(randLotto)
            allRandomRotto.add(randLotto)
        }
    }
}
