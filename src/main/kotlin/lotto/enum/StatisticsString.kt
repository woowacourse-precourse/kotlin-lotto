package lotto.enum

enum class StatisticsString(val string: String) {
    HEADER(
        """
        당첨 통계
        ---
    """.trimIndent()
    ) {
        override fun print(number: Any) = println(string)
    },
    WINNING_FIFTH("3개 일치 (${Reward.FIFTH.rewardString()}원) - ") {
        override fun print(number: Any) = println("$string${number}개")
    },
    WINNING_FOURTH("4개 일치 (${Reward.FOURTH.rewardString()}원) - ") {
        override fun print(number: Any) = println("$string${number}개")
    },
    WINNING_THIRD("5개 일치 (${Reward.THIRD.rewardString()}원) - ") {
        override fun print(number: Any) = println("$string${number}개")
    },
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (${Reward.SECOND.rewardString()}원) - ") {
        override fun print(number: Any) = println("$string${number}개")
    },
    WINNING_FIRST("6개 일치 (${Reward.FIRST.rewardString()}원) - ") {
        override fun print(number: Any) = println("$string${number}개")
    },
    EARNINGS_RATE("") {
        override fun print(number: Any) = println("총 수익률은 ${String.format("%.1f", number)}%입니다.")
    };

    abstract fun print(number: Any = 0)

    companion object {
        fun printStatics(winningDetails: List<Int>, earningsRate: Double) {
            HEADER.print()
            WINNING_FIFTH.print(winningDetails[0])
            WINNING_FOURTH.print(winningDetails[1])
            WINNING_THIRD.print(winningDetails[2])
            WINNING_SECOND.print(winningDetails[3])
            WINNING_FIRST.print(winningDetails[4])
            EARNINGS_RATE.print(earningsRate)
        }
    }
}