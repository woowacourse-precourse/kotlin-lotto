package lotto.domain

enum class Win(
    val matchBall: Int,
    val bonusBall: Boolean
) {
    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FOURTH_PLACE(4, false),
    FIFTH_PLACE(3, false),
    NO_LUCK(0, false);
}