package lotto

enum class Matching(val index: Int, val prize: Long) {
    THREE(0, 5000), FOUR(1, 50000), FIVE(2, 1500000), FIVE_AND_BONUS(3, 30000000), SIX(4, 2000000000);
}
