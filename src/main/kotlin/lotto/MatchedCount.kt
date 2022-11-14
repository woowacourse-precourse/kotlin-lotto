package lotto

private const val THREE_PRIZE = 5000
private const val FOUR_PRIZE = 50000
private const val FIVE_PRIZE = 1500000
private const val FIVE_BONUS_PRIZE = 30000000
private const val SIX_PRIZE = 2000000000

private const val INVALID_ORDINAL = "[ERROR] ENUM 클래스에 없는 값입니다."

enum class MatchedCount(val matchCount: Int, val prizeMoney: Int) {
    TRHEE(3, THREE_PRIZE) {
        override val gradeDescription: String = "3개 일치 (5,000원) - "
    },
    FOUR(4, FOUR_PRIZE) {
        override val gradeDescription: String = "4개 일치 (50,000원) - "
    },
    FIVE(5, FIVE_PRIZE) {
        override val gradeDescription: String = "5개 일치 (1,500,000원) - "
    },
    FIVE_BONUS(5, FIVE_BONUS_PRIZE) {
        override val gradeDescription: String = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    },
    SIX(6, SIX_PRIZE) {
        override val gradeDescription: String = "6개 일치 (2,000,000,000원) - "
    };

    abstract val gradeDescription: String

    fun printLottoResult(count: Int) {
        val result = count.toString() + "개"
        println(gradeDescription + result)
    }

    companion object {

        fun matchRank(ordinal: Int, bonusMatch: Boolean): MatchedCount {
            values().forEach {
                if ((ordinal == 5) and bonusMatch) return FIVE_BONUS
                if (it.matchCount == ordinal) return it
            }
            throw IllegalArgumentException(INVALID_ORDINAL)
        }
    }
}
