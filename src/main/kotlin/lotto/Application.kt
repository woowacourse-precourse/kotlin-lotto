package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
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
        statistic.statisticMessage()
        println("총 수익률은 ${statistic.calculateTotalYield(machine.getLottoCount() * 1000)}%입니다.")
    } catch (exception: IllegalArgumentException) {
        println("[ERROR] 입력에 오류가 있습니다.")
    }
}