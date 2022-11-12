package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.LOTTO_PURCHASE_MESSAGE
import lotto.LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE
import lotto.domain.Lotto
import lotto.domain.LottoExceptionHandler.validateAmountUnit
import lotto.domain.LottoExceptionHandler.validateIntType
import lotto.domain.LottoExceptionHandler.validatePositiveNumber

object LottoConsole {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine()
        validatePurchaseAmount(amount)

        return amount.toInt()
    }

    fun printPurchaseResult(lottos: List<Lotto>) {
        printPurchasedLottoCount(lottos.size)
        printPurchasedLottos(lottos)
    }

    private fun printPurchasedLottoCount(lottoCount: Int) {
        println(LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE.format(lottoCount))
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }

    private fun validatePurchaseAmount(amount: String) {
        validateIntType(amount)
        validatePositiveNumber(amount.toInt())
        validateAmountUnit(amount.toInt())
    }
}