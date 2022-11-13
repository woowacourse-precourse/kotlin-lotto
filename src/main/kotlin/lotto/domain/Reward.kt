package lotto.domain

enum class Reward(val same: Int, val bonus: Boolean, val money: String) {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FORTH(4, false, "50,000"),
    FIFTH(3, false, "5,000");

    companion object {
        private const val INPUT_EXCEPTION = "잘못된 입력입니다. 순위를 입력해주세요"
        fun getRank(cnt: Int, bonus: Boolean): String {
            return when {
                cnt == FIRST.same -> "FIRST"
                cnt == SECOND.same && SECOND.bonus -> "SECOND"
                cnt == THIRD.same -> "THIRD"
                cnt == FORTH.same -> "FORTH"
                cnt == FIFTH.same -> "FIFTH"
                else -> "NOTHING"
            }
        }

        fun getPrizeMoney(rank: String): String {
            return when (rank) {
                "FIRST" -> FIRST.money
                "SECOND" -> SECOND.money
                "THIRD" -> THIRD.money
                "FORTH" -> FORTH.money
                "FIFTH" -> FIFTH.money
                else -> throw IllegalArgumentException(INPUT_EXCEPTION)
            }
        }

        fun getSameCount(rank: String): Int {
            return when (rank) {
                "FIRST" -> FIRST.same
                "SECOND" -> SECOND.same
                "THIRD" -> THIRD.same
                "FORTH" -> FORTH.same
                "FIFTH" -> FIFTH.same
                else -> throw IllegalArgumentException(INPUT_EXCEPTION)
            }
        }
    }
}