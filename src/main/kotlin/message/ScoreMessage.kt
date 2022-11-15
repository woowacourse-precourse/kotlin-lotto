package message

enum class ScoreMessage(val message: String) {
    SCORE_TITLE("\n당첨 통계"),
    SCORE_LINE("---"),
    SCORE_THREE("3개 일치 (5,000원) - "),
    SCORE_FOUR("4개 일치 (50,000원) - "),
    SCORE_FIVE("5개 일치 (1,500,000원) - "),
    SCORE_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SCORE_SIX("6개 일치 (2,000,000,000원) - "),
}