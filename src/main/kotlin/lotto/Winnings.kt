package lotto

enum class Winnings {
    FIRST_PLACE {
        override val winnings = 2000000000
        override fun toString(value: Int) = "6개 일치 (2,000,000,000원) - ${value}개"
        override fun sum(value: Int) = winnings * value
    },
    SECOND_PLACE {
        override val winnings = 3000000
        override fun toString(value: Int) = "5개 일치, 보너스 볼 일치 (30,000,000원) - ${value}개"
        override fun sum(value: Int) = 3000000 * value
    },
    THIRD_PLACE {
        override val winnings = 1500000
        override fun toString(value: Int) = "5개 일치 (1,500,000원) - ${value}개"
        override fun sum(value: Int) = winnings * value
    },
    FOURTH_PLACE {
        override val winnings = 50000
        override fun toString(value: Int) = "4개 일치 (50,000원) - ${value}개"
        override fun sum(value: Int) = winnings * value
    },
    FIFTH_PLACE {
        override val winnings = 5000
        override fun toString(value: Int) = "3개 일치 (5,000원) - ${value}개"
        override fun sum(value: Int) = winnings * value
    };

    abstract val winnings: Int
    abstract fun toString(value: Int): String
    abstract fun sum(value: Int): Int
}