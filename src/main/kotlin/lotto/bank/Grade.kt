package lotto.bank

enum class Grade(
    val prizeMoney: Int,
    val winningMainLottoNumbersCount: Int,
    val prizeGradesIndex: Int,
    val gradeNumber: Int
) {
    FIRST(2000000000, 6, 0, 1),
    SECOND(30000000, 5, 1, 2),
    THIRD(1500000, 5, 2, 3),
    FOURTH(50000, 4, 3, 4),
    FIFTH(5000, 3, 4, 5);

    companion object {
        const val SECOND_AND_THIRD_WINNING_MAIN_LOTTO_NUMBERS_COUNT = 5
    }
}
