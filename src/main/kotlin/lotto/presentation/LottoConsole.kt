package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE
import lotto.LOTTO_PURCHASE_MESSAGE
import lotto.WINNING_LOTTO_ENTER_MESSAGE
import lotto.domain.Lotto
import lotto.domain.LottoExceptionHandler.validateIntType
import lotto.domain.Money

object LottoConsole {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Money {
        val amount = Console.readLine()
        validateIntType(amount)

        return Money(amount.toInt())
    }

    fun printPurchaseResult(lottos: List<Lotto>) {
        printPurchasedLottoCount(lottos.size)
        printPurchasedLottos(lottos)
    }

    fun printWinningLottoEnterMessage() {
        println(WINNING_LOTTO_ENTER_MESSAGE)

    }

    private fun printPurchasedLottoCount(lottoCount: Int) {
        println(LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE.format(lottoCount))
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }
}