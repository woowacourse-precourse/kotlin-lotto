package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.BonusNumber
import lotto.domain.LottoMachine
import lotto.domain.Statistic
import lotto.domain.WinningNumber
import lotto.util.ConsoleMessage
import lotto.util.ErrorMessage

fun main() {
    try {
        startLotto()
    } catch (exception: IllegalArgumentException) {
        println(ErrorMessage.systemError())
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
    val statistic = Statistic(rank)
    statistic.printWinningHistory()
    statistic.printYield(machine.getLottoCount())
}