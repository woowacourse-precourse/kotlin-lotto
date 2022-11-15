package util

enum class Game (val message: String) {
    PRICE_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    WINNING_RESULT("당첨 통계\n---"),
    RANKING_FIFTH("3개 일치 (5,000원) - %d개"),
    RANKING_FOURTH("4개 일치 (50,000원) - %d개"),
    RANKING_THIRD("5개 일치 (1,500,000원) - %d개"),
    RANKING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANKING_FIRST("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_1("총 수익률은 %.1f"),
    TOTAL_PROFIT_2("%입니다.")
}