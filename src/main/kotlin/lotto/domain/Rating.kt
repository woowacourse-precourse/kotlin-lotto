package lotto.domain

enum class Rating(
    private val hit: Int,
    private val prize: Int,
    private val bonus: Boolean
) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSE(0, 0, false);

    fun isWinningLotto(hit: Int, bonus: Boolean): Rating {
        if ((hit == 6) and (!bonus)) {
            return FIRST
        }
        if ((hit == 5) and (bonus)) {
            return SECOND
        }
        if ((hit == 5) and (!bonus)) {
            return THIRD
        }
        if ((hit == 4) and (!bonus)) {
            return FOURTH
        }
        if ((hit == 3) and (!bonus)) {
            return FIFTH
        }
        return LOSE
    }
}