package lotto

import lotto.domain.*
import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val purchase = Purchase()
    val amount = purchase.buyLotto()
    OutputView.printAmount(amount)
    val lottos = purchase.createLottos(amount)
    OutputView.printLottos(lottos)
    val winningLotto = WinningLotto().createWinningLotto()
    val bonusNumber = BonusNumber().createBonusNumber()
    val rewards = getReward(lottos, winningLotto, bonusNumber)
    OutputView.printCountReward(countReward(rewards))
    OutputView.printYield(calculateYield(rewards, amount))
}
