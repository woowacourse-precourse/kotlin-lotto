package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.utils.LottoExceptionHandler.validateIntType
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.utils.*

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

    fun inputWinningLottoNumbers(): WinningLotto {
        val numbers = Console.readLine()
        val lottoNumbers = Separator.separateToInts(numbers, ',')
            .map { LottoNumber(it) }

        return WinningLotto(lottoNumbers)
    }

    fun printBonusNumberEnterMessage() {
        println(BONUS_NUMBER_ENTER_MESSAGE)
    }

    private fun printPurchasedLottoCount(lottoCount: Int) {
        println(LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE.format(lottoCount))
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }
}