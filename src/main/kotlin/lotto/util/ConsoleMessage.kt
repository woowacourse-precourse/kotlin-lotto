package lotto.util

import lotto.domain.Lotto

class ConsoleMessage {
    companion object {
        fun enterPurchaseAmount() = println("구입 금액을 입력해 주세요.")

        fun purchased(count: Int) = println("\n${count}개를 구매했습니다.")

        fun enterWinningNumber() = println("\n당첨 번호를 입력해 주세요.")

        fun enterBonusNumber() = println("\n보너스 번호를 입력해 주세요.")

        fun winningHistory(ranks: List<Int>) {
            println(
                "\n당첨 통계" +
                        "\n---"
            )
            Rank.values().forEach { index ->
                println("${index.message} ${ranks[index.rank]}개")
            }
        }

        fun earningRate(rate: Double) = println("총 수익률은 $rate%입니다.")

        fun lotteryNumbers(lottery: List<Lotto>) = lottery.forEach {
            println(it.getLottoNumber())
        }
    }
}