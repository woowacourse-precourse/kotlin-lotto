package lotto

class MessageMaker {
    fun purchaseInputPleaseMessage() {
        println(PURCHASE_INPUT_PLEASE_MESSAGE)
    }

    fun purchaseCountMessage(count: Int) {
        println("\n$count" + PURCHASE_COUNT_MESSAGE)
    }

    fun purchaseLotteryListMessage(lottery: List<Lotto>) {
        lottery.forEach { println(it.lottoEnumeration()) }
    }

    fun winningLotteryInputMessage() {
        println(WINNING_LOTTERY_INPUT_MESSAGE)
    }

    fun bonusInputMessage() {
        println(BONUS_INPUT_MESSAGE)
    }

    fun winningStatisticsMessage() {
        println(WINNING_STATISTICS_MESSAGE)
    }

    fun statisticsMessage(statistics: List<Int>) {
        for (i in statistics.indices) {
            when (i) {
                MatchResult.THREE.index -> statisticsMatchResultMessage(MatchMessage.THREE_MATCH, statistics[i])
                MatchResult.FOUR.index -> statisticsMatchResultMessage(MatchMessage.FOUR_MATCH, statistics[i])
                MatchResult.FIVE.index -> statisticsMatchResultMessage(MatchMessage.FIVE_MATCH, statistics[i])
                MatchResult.BONUS.index -> statisticsMatchResultMessage(MatchMessage.BONUS_MATCH, statistics[i])
                else -> statisticsMatchResultMessage(MatchMessage.SIX_MATCH, statistics[i])
            }
        }
    }

    private fun statisticsMatchResultMessage(matchMessage: MatchMessage, matchCount: Int) {
        println("${matchMessage.matchMessage} (${matchMessage.money}) - ${matchCount}개")
    }

    fun statisticsYieldMessage(result: Double) {
        println("$ALL_YIELD ${String.format("%.1f", result)}$IS")
    }

    companion object {
        private const val PURCHASE_INPUT_PLEASE_MESSAGE = "구입금액을 입력해 주세요."
        private const val PURCHASE_COUNT_MESSAGE = "개를 구매했습니다."
        private const val WINNING_LOTTERY_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요."
        private const val BONUS_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요."
        private const val WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---"
        private const val ALL_YIELD = "총 수익률은"
        private const val IS = "%입니다."

        lateinit var errorType: Error
        fun errorMessage() {
            println(errorType.error)
        }
    }

    enum class MatchMessage(val matchMessage: String, val money: String) {
        THREE_MATCH("3개 일치", "5,000원"),
        FOUR_MATCH("4개 일치", "50,000원"),
        FIVE_MATCH("5개 일치", "1,500,000원"),
        BONUS_MATCH("5개 일치, 보너스 볼 일치", "30,000,000원"),
        SIX_MATCH("6개 일치", "2,000,000,000원"),
    }

    enum class Error(val error: String) {
        PURCHASE_IS_NOT_ONE_INTEGER("[ERROR] 구입 금액은 숫자 한개여야 합니다."),
        PURCHASE_MONEY("[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다."),
        LOTTERY_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        WINNING_INPUT_COUNT_ERROR("[ERROR] 로또 당첨 번호를 콤마로 구분해서 1부터 45 사이의 숫자 6개를 입력해주세요."),
        WINNING_INPUT_DISTINCT_ERROR("[ERROR] 로또 당첨 번호를 중복 없이 입력해주세요."),
        BONUS_ALREADY_IN_WINNING("[ERROR] 보너스 번호가 이미 당첨 번호에 포함되어 있습니다."),
        BONUS_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        NON_ERROR("에러 없음"),
    }
}