package lotto.constants

enum class LottoWinCaseMoney(val caseNum: Int, val prize: Long) {
    FIRST_WIN_MONEY(4, 2000000000),
    SECOND_WIN_MONEY(3, 30000000),
    THIRD_WIN_MONEY(2, 1500000),
    FOURTH_WIN_MONEY(1, 50000),
    FIFTH_WIN_MONEY(0, 5000);

    companion object {
        fun getPrizeMoney(caseNum: Int): Long {
            for (case in LottoWinCaseMoney.values()) {
                if (case.caseNum == caseNum) {
                    return case.prize
                }
            }

            return -1
        }
    }


}