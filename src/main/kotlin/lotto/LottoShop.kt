package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoShop {

    fun buyLotto() {
        println("구입금액을 입력해 주세요.")
        val buyAmount = readLine()!!.toInt()
        cntLotto(buyAmount)

    }

    fun cntLotto(purchaseAmount: Int): Int {
        if (purchaseAmount % 1000 != 0) throw IllegalArgumentException("[ERROR] 숫자가 나누어 떨어지지 않습니다.")
        val purchaseCnt = (purchaseAmount / 1000)
        println("${purchaseCnt}개를 구매했습니다.")

        return purchaseCnt

    }

    fun createRandomLotto() {
    }
}