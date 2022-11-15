package _enum

enum class LottoEnum(val message: String, var count: Int, val price: Int) {
    THREE_CORRECT("3개 일치 (5,000원)",0, 5000),
    FOUR_CORRECT("4개 일치 (50,000원)", 0, 50000),
    FIVE_CORRECT("5개 일치 (1,500,000원)", 0, 1500000),
    FIVE_CORRECT_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)",0, 30000000),
    SIX_CORRECT("6개 일치 (2,000,000,000원)",0, 2000000000)
}