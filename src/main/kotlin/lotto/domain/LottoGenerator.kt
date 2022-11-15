package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun issueLottos(numberOfPurchaseLotto: Int): Lottos {
        val purchasedLottos = mutableListOf<Lotto>()
        for (i in 0 until numberOfPurchaseLotto) {
            val lotto = issueLotto()
            purchasedLottos.add(lotto)
        }
        return Lottos(purchasedLottos)
    }

    private fun issueLotto(): Lotto {
        var lottoNum: MutableList<Int>
        while (true) {
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            if (nums.distinct().size == NUMBERS_PER_LOTTO) {
                lottoNum = nums
                break
            }
        }
        lottoNum.sort()
        return Lotto(lottoNum)
    }

    companion object {
        const val NUMBERS_PER_LOTTO = 6
    }
}