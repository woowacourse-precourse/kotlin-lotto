package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoShop {

    fun buyLotto() {
        println("구입금액을 입력해 주세요.")
        val buyAmount = readLine()!!
        if (!buyAmount.inputTypeException()) return
        val buyCntLotto = cntLotto(buyAmount.inputMoneyException())
    }

    fun cntLotto(purchaseAmount: Int): Int {
        val purchaseCnt = (purchaseAmount / 1000)
        println("${purchaseCnt}개를 구매했습니다.")
        return purchaseCnt
    }

    fun String.inputMoneyException(): Int {
        if (this.toInt() % 1000 == 0) return this.toInt()
        throw IllegalArgumentException("[ERROR] 숫자가 나누어 떨어지지 않습니다.")
    }

    fun String.inputTypeException(): Boolean {
        return try {
            this.toInt()
            true

        } catch (e: NumberFormatException) {
            println("[ERROR] 구입 금액을 잘못입력하셨습니다.")
            false
        }
    }

    fun createRandomLotto() {
    }
}