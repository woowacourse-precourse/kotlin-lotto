package lotto.bank

enum class Grade(val prizeMoney: Int, val winningMainLottoNumbersCount: Int, val prizeGradesIndex: Int) {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 2),
    FOURTH(50000, 4, 3),
    FIFTH(5000, 3, 4);

    companion object {
        const val SECOND_AND_THIRD_WINNING_MAIN_LOTTO_NUMBERS_COUNT = 5
    }
}

