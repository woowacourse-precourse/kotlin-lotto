package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val amount = inputPurchaseAmount().toIntOrError()
    val tickets = purchaseTickets(amount)
    val winningLotto = registerWinningLotto()
    val (resultRank, totalPrize) = Purchaser().calculateResult(winningLotto, tickets)

    printPrizeResult(resultRank)
    printRateOfReturn(Purchaser().calculateRateOfReturn(totalPrize, amount))
}

fun purchaseTickets(amount: Int): List<Lotto> {
    val tickets = Purchaser().purchase(amount)
    printNumberOfTickets(tickets.size)
    printNumbersOfLottos(tickets)

    return tickets
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumber().toIntOrError()
    printBonusNumber(bonusNumber)

    return WinningLotto(winningNumbers, bonusNumber)
}
