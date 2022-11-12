package lotto

enum class LottoGrade(val prize : Int) {

    FIRST(2_000_000_000) {
        override fun toString(): String {
            return "6개 일치 (2,000,000,000원) - "
        }
    },
    SECOND(30_000_000) {
        override fun toString(): String {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        }
    },
    THIRD(1_500_000) {
        override fun toString(): String {
            return "5개 일치 (1,500,000원) - "
        }
    },
    FOURTH(50_000) {
        override fun toString(): String {
            return "4개 일치 (50,000원) - "
        }
    },
    FIFTH(5_000) {
        override fun toString(): String {
            return "3개 일치 (5,000원) - "
        }
    },
    NOTHING(0);

}