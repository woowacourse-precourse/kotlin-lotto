package lotto.domain

enum class LottoRank(
    val numberOfSame: Int,
    val bonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun of(numberOfSame: Int, bonus: Boolean): LottoRank {
            return values().filter {
                it.numberOfSame == numberOfSame &&
                it.bonus == bonus
            }.getOrElse(0) { NONE }
        }
    }
}
