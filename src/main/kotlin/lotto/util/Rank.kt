package lotto.util

enum class Rank(val message: String, val money: Int, val rank: Int) {
    FIFTH("3개 일치 (5,000원) -", 5000, 5),
    FOURTH("4개 일치 (50,000원) -", 50000, 4),
    THIRD("5개 일치 (1,500,000원) -", 1500000, 3),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) -", 30000000, 2),
    FIRST("6개 일치 (2,000,000,000원) -", 2000000000, 1);
}