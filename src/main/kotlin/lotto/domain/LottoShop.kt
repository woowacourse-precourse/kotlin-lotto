package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoShop {

    fun buyLotto(money: Int) : List<Lotto> {
        val buyCntLotto = cntLotto(money)
        return createRandomLotto(buyCntLotto)
    }

    fun cntLotto(purchaseAmount: Int): Int {
        val purchaseCnt = (purchaseAmount / 1000)
        println("\n${purchaseCnt}개를 구매했습니다.")
        return purchaseCnt
    }

    fun createRandomLotto(purchaseCnt: Int): List<Lotto> {
        val myLottoNumber = mutableListOf<Lotto>()
        for (i in 0 until purchaseCnt) {
            val randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(randomLotto)
            myLottoNumber.add(Lotto(randomLotto))
        }
        return myLottoNumber
    }
}