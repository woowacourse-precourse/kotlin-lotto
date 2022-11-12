package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*
import lotto.util.ConsoleMessage

fun main() {
    try {
        startLotto()
    } catch (_: IllegalArgumentException) {
    }
}

fun startLotto() {
    ConsoleMessage.machine()
    val machine = LottoMachine(Console.readLine())
    machine.pickNewLotto(machine.getLottoCount())
    ConsoleMessage.purchase(machine.getLottoCount())
    machine.getLottoNumbers()
    ConsoleMessage.winning()
    val winning = WinningNumber(Console.readLine())
    ConsoleMessage.bonus()
    val bonus = BonusNumber(winning.getWinningNumber(), Console.readLine())
    val rank = machine.getTotalRank(winning.getWinningNumber(), bonus.getBonusNumber())
    val earning = Earning(rank)
    ConsoleMessage.winningHistory(rank)
    ConsoleMessage.earningRate(earning.getRate(machine.getLottoCount()))
}