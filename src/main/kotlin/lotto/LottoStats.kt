package lotto

enum class LottoStats(val message: String, val price: Int, val answerCnt: Int, val bonusCnt: Int) {
    FIRST_RANK("6개 일치", 2_000_000_000, 6, 0),
    SECOND_RANK("5개 일치, 보너스볼 일치", 30_000_000, 5, 1),
    THIRD_RANK("5개 일치", 1500000, 5, 0),
    FORTH_RANK("4개 일치", 50000, 4, 0),
    FIFTH_RANK("3개 일치", 5000, 3, 0);
}