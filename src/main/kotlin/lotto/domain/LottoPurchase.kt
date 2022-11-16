package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.RESULT_AMOUNT_PURCHASE_MESSAGE

class LottoPurchase(userGameAmount: Int) {
    private val lottoCount = userGameAmount / 1000

    fun randomLottoPurchase(): MutableList<Lotto> {
        println("$lottoCount" + RESULT_AMOUNT_PURCHASE_MESSAGE)
        val randomLottoGroup = mutableListOf<Lotto>()
        for (i in 0 until lottoCount)
            randomLottoGroup.add(makeRandomLotto())

        return randomLottoGroup
    }

    private fun makeRandomLotto(): Lotto {
        val randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        println(randomLotto)
        return Lotto(randomLotto)
    }
}