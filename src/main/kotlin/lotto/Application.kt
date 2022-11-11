package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")
    val machine = LottoMachine(Console.readLine())
    machine.pickNewLotto(machine.getLottoCount())
    println("\n${machine.getLottoCount()}개를 구매했습니다.")
    machine.getLottoNumbers()
    println("\n당첨 번호를 입력해 주세요.")
    val winning = Winning(Console.readLine())
    println("\n보너스 번호를 입력해 주세요.")
    winning.inputBonusNumber(Console.readLine())
    winning.checkBonusNumberException()
    val rank = machine.getTotalRank(winning.getLuckyNumber(),winning.getBonusNumber())
    val statistic = Statistic(rank)
    statistic.statisticMessage()
    println("총 수익률은 ${statistic.calculateTotalYield(machine.getLottoCount() * 1000)}%입니다.")

}