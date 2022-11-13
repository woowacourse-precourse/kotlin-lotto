package lotto

enum class LottoReward(val cnt: Int, val prize: String) {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "30,000,000"),
    THIRD(5, "1,500,000"),
    FOURTH(4, "50,000"),
    FIFTH(3, "5,000"),
    NOTHING(0, "0")
}