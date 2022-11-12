package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.BonusNumber
import lotto.domain.Earning
import lotto.domain.LottoMachine
import lotto.domain.WinningNumber
import lotto.util.ConsoleMessage

fun main() {
    try {
        startLotto()
    } catch (_: IllegalArgumentException) {
    }
}

private fun startLotto() {
    ConsoleMessage.enterPurchaseAmount()
    val machine = LottoMachine(Console.readLine())
    machine.pickNewLottery(machine.getLottoCount())
    ConsoleMessage.purchased(machine.getLottoCount())
    ConsoleMessage.lotteryNumbers(machine.getLottery())

    ConsoleMessage.enterWinningNumber()
    val winning = WinningNumber(Console.readLine())
    ConsoleMessage.enterBonusNumber()
    val bonus = BonusNumber(winning.getWinningNumber(), Console.readLine())

    val ranks = machine.getRanks(winning.getWinningNumber(), bonus.getBonusNumber())
    val earning = Earning(ranks)
    ConsoleMessage.winningHistory(ranks)
    ConsoleMessage.earningRate(earning.getRate(machine.getLottoCount()))
}