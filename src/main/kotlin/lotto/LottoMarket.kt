package lotto

import lotto.util.ErrorType
import lotto.util.printErrorMessage
import lotto.util.readSpendMoney

class LottoMarket(
    val lottoFactory: LottoFactory,
) {
    private var spendMoney: Int? = null

    fun askSpendMoney() {
        println("로또 구입 금액을 입력해 주세요.")
        spendMoney = readSpendMoney()
    }

    //로또 구입 금액만큼 로또 반환
    fun getLottoCount(): Int {
        spendMoney?.let {
            return it / 1000
        }
        printErrorMessage(ErrorType.EMPTY_VALUE)
        throw IllegalArgumentException()
    }
}