package lotto.util

import lotto.domain.Lotto

class ConsoleMessage {
    companion object {
        fun machine() = println("구입 금액을 입력해 주세요.")

        fun purchase(count: Int) = println("\n${count}개를 구매했습니다.")

        fun winning() = println("\n당첨 번호를 입력해 주세요.")

        fun bonus() = println("\n보너스 번호를 입력해 주세요.")

        fun winningHistory(ranks: List<Int>) {
            println("\n당첨 통계")
            println("---")
            Rank.values().forEach { rank ->
                println("${rank.message} ${ranks[rank.index]}개")
            }
        }

        fun earningRate(rate: Double) = println("총 수익률은 $rate%입니다.")

        fun lotteryNumbers(lottery: List<Lotto>) = lottery.forEach {
            println(it.getLottoNumber())
        }
    }
}