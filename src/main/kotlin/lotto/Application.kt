package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val purchaser = purchaseLottos(inputPurchaseAmount())
    val winningLotto = registerWinningLotto()
    val (resultRank, totalPrize) = purchaser.calculateResult(winningLotto)

    printPrizeResult(resultRank)
    printRateOfReturn((totalPrize * 10000 / (purchaser.amount) / 100.0F))
}

fun purchaseLottos(amount: Int?): Purchaser {
    val purchaser = Purchaser(amount)

    purchaser.tickets = Store().buyTickets(purchaser.amount).map { Lotto(it) }
    printNumberOfTickets(purchaser.tickets.size)
    printNumbersOfLottos(purchaser.tickets)

    return purchaser
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumber()
    printBonusNumber(bonusNumber.checkNull())

    return WinningLotto(winningNumbers, bonusNumber.checkNull())
}
