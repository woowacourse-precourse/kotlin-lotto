package lotto.model

import lotto.model.Buyer.getBuyCount
import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    fun generateLotto(count: Int): List<List<Int>> {
        val lottos = mutableListOf<List<Int>>()
        for (i in 0 until count) {
            var lotto = Randoms.pickUniqueNumbersInRange(1,45,6)
            lottos.add(lotto.sorted())
        }
        return lottos.toList()
    }

/*    companion object {
        var winningNumber = listOf<Int>()
        var bonusNumber = ""
        var allRandomRotto = mutableListOf<List<Int>>()
    }

    fun generateLotto(LottoCnt: Int) {
        for (cnt in 0 until LottoCnt) {
            var randLotto = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE).sorted()
            println(randLotto)
            allRandomRotto.add(randLotto)
        }
    }*/
}
