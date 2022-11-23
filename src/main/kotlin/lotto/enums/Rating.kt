package lotto.enums

enum class Rating(
    private val hit: Int,
    private val prize: Int,
    private val bonus: Boolean
) : RatingInterface {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSE(0, 0, false);

    override fun getHit(): Int {
        return hit
    }

    override fun getPrize(): Int {
        return prize
    }

    override fun getBonus(): Boolean {
        return bonus
    }
}