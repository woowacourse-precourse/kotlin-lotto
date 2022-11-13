package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val purchaser = purchaseLottos(inputPurchaseAmount())
    val winningLotto = registerWinningLotto()

    purchaser.calculateResult(winningLotto)

    printPrizeResult(purchaser.resultRank)
    printRateOfReturn(purchaser.rateOfReturn)
}

fun purchaseLottos(amount: Int?): Purchaser {
    val purchaser = Purchaser(amount)
    printNumberOfTickets(purchaser.ticket)

    purchaser.lotto = Store().buyLotto(purchaser.ticket).map { Lotto(it) }
    printNumbersOfLottos(purchaser.lotto)

    return purchaser
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumbers()
    printBonusNumber(bonusNumber.checkNull())

    return WinningLotto(winningNumbers, bonusNumber.checkNull())
}
