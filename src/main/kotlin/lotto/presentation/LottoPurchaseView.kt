package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.utils.LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE
import lotto.utils.LOTTO_PURCHASE_MESSAGE
import lotto.utils.LottoExceptionHandler

object LottoPurchaseView {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Money {
        val amount = Console.readLine()
        LottoExceptionHandler.validateIntType(amount)
        LottoExceptionHandler.validateAmountUnit(amount.toInt())

        return Money(amount.toInt())
    }

    fun printPurchaseResult(lottos: List<Lotto>) {
        printEnter()
        printPurchasedLottoCount(lottos.size)
        printPurchasedLottos(lottos)
    }

    private fun printPurchasedLottoCount(lottoCount: Int) {
        println(LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE.format(lottoCount))
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }

    private fun printEnter() = println()
}