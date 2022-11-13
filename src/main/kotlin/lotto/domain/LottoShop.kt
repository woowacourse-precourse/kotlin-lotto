package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.presentation.util.Constant.lottoCost
import lotto.presentation.util.Constant.lottoSize
import lotto.presentation.util.Constant.maxLottoNumber
import lotto.presentation.util.Constant.minLottoNumber
import lotto.presentation.util.Constant.printBuyMessage

class LottoShop {

    fun buyLotto(money: Int) : List<Lotto> {
        val buyCntLotto = cntLotto(money)
        return createRandomLotto(buyCntLotto)
    }

    fun cntLotto(purchaseAmount: Int): Int {
        val purchaseCnt = (purchaseAmount / lottoCost)
        println("\n${purchaseCnt}$printBuyMessage")
        return purchaseCnt
    }

    fun createRandomLotto(purchaseCnt: Int): List<Lotto> {
        val myLottoNumber = mutableListOf<Lotto>()
        for (i in 0 until purchaseCnt) {
            val randomLotto = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoSize)
            randomLotto.sort()
            println(randomLotto)
            myLottoNumber.add(Lotto(randomLotto))
        }
        return myLottoNumber
    }
}