package lotto

enum class Prize(val earnings: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NOTHING(0);

    /**
     * @return Prize according to [ball] and [bonus]
     */
    fun updatePrize(ball: Int, bonus: Boolean): Prize {
        when(ball) {
            6 -> return FIRST
            5 -> return if(bonus) SECOND else THIRD
            4 -> return FOURTH
            3 -> return FIFTH
        }
        return NOTHING
    }
}