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

    purchaser.lotto = Store().buyLotto(purchaser.amount).map { Lotto(it) }
    printNumberOfTickets(purchaser.lotto.size)
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
