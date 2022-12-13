package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Buyer.lottoCount

class LottoMaker {
    fun generateLotto(): List<List<Int>> {
        val lottos = mutableListOf<List<Int>>()
        for (i in 0 until lottoCount) {
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
