package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val purchaser = Purchaser(inputPurchaseAmount())
    printNumberOfTickets(purchaser.ticket)

    val lottos = Store().buyLotto(purchaser.ticket).map { Lotto(it) }
    printNumbersOfLottos(lottos)

    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumbers()
    printBonusNumber(bonusNumber.checkNull())

    val winningLotto = WinningLotto(winningNumbers, bonusNumber.checkNull())

    lottos.map {
        purchaser.resultRank[winningLotto.getRank(it.toList()) - 1] += 1
        purchaser.totalPrize += winningLotto.getPrize(it.toList())
    }
    printPrizeResult(purchaser.resultRank)
    printRateOfReturn(purchaser.rateOfReturn)
}
