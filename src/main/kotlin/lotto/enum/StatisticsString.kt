package lotto.enum

enum class StatisticsString(val string: String) {
    HEADER(
        """
        당첨 통계
        ---
    """.trimIndent()){
        override fun print(number: Int) = println(string)
    },
    WINNING_FIFTH("3개 일치 (${Reward.FIFTH_REWARD.rewardString()}원) - "){
        override fun print(number: Int) = println("$string${number}개")
    },
    WINNING_FOURTH("4개 일치 (${Reward.FOURTH_REWARD.rewardString()}원) - "){
        override fun print(number: Int) = println("$string${number}개")
    },
    WINNING_THIRD("5개 일치 (${Reward.THIRD_REWARD.rewardString()}원) - "){
        override fun print(number: Int) = println("$string${number}개")
    },
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (${Reward.SECOND_REWARD.rewardString()}원) - "){
        override fun print(number: Int) = println("$string${number}개")
    },
    WINNING_FIRST("6개 일치 (${Reward.FIRST_REWARD.rewardString()}원) - "){
        override fun print(number: Int) = println("$string${number}개")
    },
    EARNINGS_RATE(""){
        override fun print(number: Int) = println("총 수익률은 $number%입니다.")
    };

    abstract fun print(number: Int = 0)
}