package lotto

enum class Reward(val winningCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    MISS(0);
}