package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val amount = inputPurchaseAmount().checkNull()
    val tickets = purchaseTickets(amount)
    val winningLotto = registerWinningLotto()
    val (resultRank, totalPrize) = Purchaser().calculateResult(winningLotto, tickets)

    printPrizeResult(resultRank)
    printRateOfReturn((totalPrize * 10000 / (amount) / 100.0F))
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

    val bonusNumber = inputBonusNumber().checkNull()
    printBonusNumber(bonusNumber)

    return WinningLotto(winningNumbers, bonusNumber)
}
