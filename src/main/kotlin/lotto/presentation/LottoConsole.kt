package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*
import lotto.utils.LottoExceptionHandler.validateIntType
import lotto.utils.*
import lotto.utils.LottoExceptionHandler.validateAmountUnit

object LottoConsole {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Money {
        val amount = Console.readLine()
        validateIntType(amount)
        validateAmountUnit(amount.toInt())

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
        val lottoNumbers = Separator.separateToInts(numbers, ',').map { number -> LottoNumber(number) }
            .sortedBy { lottoNumber -> lottoNumber.number }

        return WinningLotto(lottoNumbers)
    }

    fun printBonusNumberEnterMessage() {
        println(BONUS_NUMBER_ENTER_MESSAGE)
    }

    fun inputBonusNumber(): LottoNumber {
        val number = Console.readLine()
        validateIntType(number)

        return LottoNumber(number.toInt())
    }

    fun printLottoStatics(lottoRanks: LottoRanks, earned: Money, investment: Money) {
        println(LOTTO_STATIC_MESSAGE)
        printMatchingLotto(lottoRanks)
        printYieldRate(earned, investment)
    }

    private fun printMatchingLotto(lottoRanks: LottoRanks) {
        lottoRanks.entries.forEach { entry ->
            val (lottoRank, count) = entry.toPair()
            println(lottoRank.message.format(count))
        }
    }

    private fun printYieldRate(earned: Money, investment: Money) {
        print(TOTAL_YIELD_RATE_MESSAGE.format(earned.calculateYieldRate(investment)))
    }

    private fun printPurchasedLottoCount(lottoCount: Int) {
        println(LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE.format(lottoCount))
    }

    private fun printPurchasedLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }
}