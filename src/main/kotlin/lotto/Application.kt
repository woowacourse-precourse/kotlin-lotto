package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val purchase = Purchase(inputPurchaseAmount())
    printNumberOfTickets(purchase.ticket)

    val lottos = Store().buyLotto(purchase.ticket).map { Lotto(it) }
    printNumbersOfLottos(lottos)

    val winningNumbers = inputLottoWinningNumbers().splitToIntList()
    printWinningNumbers(winningNumbers)

    val bonusNumber = inputBonusNumbers()
    printBonusNumber(bonusNumber.checkNull())
}
