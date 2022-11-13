package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val amount = inputPurchaseAmount().checkNull()
    val tickets = purchaseLottos(amount)
    val winningLotto = registerWinningLotto()
    val (resultRank, totalPrize) = Purchaser().calculateResult(winningLotto, tickets)

    printPrizeResult(resultRank)
    printRateOfReturn((totalPrize * 10000 / (amount) / 100.0F))
}

fun purchaseLottos(amount: Int): List<Lotto> {
    val tickets = Store().buyTickets(amount.checkNull()).map { Lotto(it) }
    printNumberOfTickets(tickets.size)
    printNumbersOfLottos(tickets)

    return tickets
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumber()
    printBonusNumber(bonusNumber.checkNull())

    return WinningLotto(winningNumbers, bonusNumber.checkNull())
}
