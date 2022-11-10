package lotto


enum class Reward(val winningCount: Int, val reward: Int) {
    FIRST(6, 1),
    SECOND(5, 2),
    THIRD(5, 3),
    FOURTH(4, 4),
    FIFTH(3, 5),
    MISS(0, 6);
}