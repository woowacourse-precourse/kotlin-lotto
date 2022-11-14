package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    try {
        val amount = inputPurchaseAmount()
        val tickets = purchaseTickets(amount)
        val winningLotto = registerWinningLotto()
        val (resultRank, totalPrize) = Purchaser.calculateResult(winningLotto, tickets)

        printPrizeResult(resultRank)
        printRateOfReturn(Purchaser.calculateRateOfReturn(totalPrize, amount))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun purchaseTickets(amount: Int): List<Lotto> {
    val tickets = Purchaser.purchase(amount)
    printNumberOfTickets(tickets.size)
    printNumbersOfLottos(tickets)

    return tickets
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumber()
    printBonusNumber(bonusNumber)

    return WinningLotto(winningNumbers, bonusNumber)
}
