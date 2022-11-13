package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val (purchaser, lottos) = purchaseLottos(inputPurchaseAmount())
    val winningLotto = registerWinningLotto()

    lottos.map {
        purchaser.resultRank[winningLotto.getRank(it.toList()) - 1] += 1
        purchaser.totalPrize += winningLotto.getPrize(it.toList())
    }
    printPrizeResult(purchaser.resultRank)
    printRateOfReturn(purchaser.rateOfReturn)
}

fun purchaseLottos(amount: Int?): Pair<Purchaser, List<Lotto>> {
    val purchaser = Purchaser(amount)
    printNumberOfTickets(purchaser.ticket)

    val lottos = Store().buyLotto(purchaser.ticket).map { Lotto(it) }
    printNumbersOfLottos(lottos)

    return Pair(purchaser, lottos)
}

fun registerWinningLotto(): WinningLotto {
    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumbers()
    printBonusNumber(bonusNumber.checkNull())

    return WinningLotto(winningNumbers, bonusNumber.checkNull())
}
