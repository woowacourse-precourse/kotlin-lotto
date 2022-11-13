package lotto.domain

enum class Rating(
    private val hit: Int,
    private val prize: Int,
    private val bonus: Boolean
) {
    FIRST(6, 2_000_000_000, false) {
        override fun getHit(): Int {
            return FIRST.hit
        }

        override fun getPrize(): Int {
            return FIRST.prize
        }

        override fun getBonus(): Boolean {
            return FIRST.bonus
        }
    },
    SECOND(5, 30_000_000, true) {
        override fun getHit(): Int {
            return SECOND.hit
        }

        override fun getPrize(): Int {
            return SECOND.prize
        }

        override fun getBonus(): Boolean {
            return SECOND.bonus
        }
    },
    THIRD(5, 1_500_000, false) {
        override fun getHit(): Int {
            return THIRD.hit
        }

        override fun getPrize(): Int {
            return THIRD.prize
        }

        override fun getBonus(): Boolean {
            return THIRD.bonus
        }
    },
    FOURTH(4, 50_000, false) {
        override fun getHit(): Int {
            return FOURTH.hit
        }

        override fun getPrize(): Int {
            return FOURTH.prize
        }

        override fun getBonus(): Boolean {
            return FOURTH.bonus
        }
    },
    FIFTH(3, 5_000, false) {
        override fun getHit(): Int {
            return FIFTH.hit
        }

        override fun getPrize(): Int {
            return FIFTH.prize
        }

        override fun getBonus(): Boolean {
            return FIFTH.bonus
        }
    },
    LOSE(0, 0, false) {
        override fun getHit(): Int {
            return LOSE.hit
        }

        override fun getPrize(): Int {
            return LOSE.prize
        }

        override fun getBonus(): Boolean {
            return LOSE.bonus
        }
    };

    abstract fun getHit(): Int
    abstract fun getPrize(): Int
    abstract fun getBonus(): Boolean
}