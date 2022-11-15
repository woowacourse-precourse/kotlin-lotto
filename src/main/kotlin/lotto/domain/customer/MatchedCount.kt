package lotto.domain.customer

private const val THREE_PRIZE = 5000
private const val FOUR_PRIZE = 50000
private const val FIVE_PRIZE = 1500000
private const val FIVE_BONUS_PRIZE = 30000000
private const val SIX_PRIZE = 2000000000

private const val THREE_RESULT = "3개 일치 (5,000원) - "
private const val FOUR_RESULT = "4개 일치 (50,000원) - "
private const val FIVE_RESULT = "5개 일치 (1,500,000원) - "
private const val FIVE_BONUS_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
private const val SIX_RESULT = "6개 일치 (2,000,000,000원) - "

private const val INVALID_ORDINAL = "[ERROR] ENUM 클래스에 없는 값입니다."

enum class MatchedCount(val matchCount: Int, val prizeMoney: Int) {
    THREE(3, THREE_PRIZE) {
        override val gradeDescription: String = THREE_RESULT
    },
    FOUR(4, FOUR_PRIZE) {
        override val gradeDescription: String = FOUR_RESULT
    },
    FIVE(5, FIVE_PRIZE) {
        override val gradeDescription: String = FIVE_RESULT
    },
    FIVE_BONUS(5, FIVE_BONUS_PRIZE) {
        override val gradeDescription: String = FIVE_BONUS_RESULT
    },
    SIX(6, SIX_PRIZE) {
        override val gradeDescription: String = SIX_RESULT
    };

    abstract val gradeDescription: String

    fun returnLottoResult(count: Int): String {
        val result = count.toString() + "개"
        return gradeDescription + result
    }

    companion object {
        private const val FIVE = 5

        fun matchRank(ordinal: Int, bonusMatch: Boolean): MatchedCount {
            values().forEach {
                if ((ordinal == FIVE) and bonusMatch) return FIVE_BONUS
                if (it.matchCount == ordinal) return it
            }
            throw IllegalArgumentException(INVALID_ORDINAL)
        }
    }
}
