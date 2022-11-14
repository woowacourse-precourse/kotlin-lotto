package Util

enum class Game(val message: String) {
    USER_INPUT("구입금액을 입력해 주세요."),

    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),

    NUMBER_OF_LOTTO_OUTPUT("%d개를 구매했습니다."),

    WINNING_LIST_OUTPUT("당첨 통계"),
    LINE_OUTPUT("---"),
    FIRST_RANKING_OUTPUT("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_RANKING_OUTPUT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_RANKING_OUTPUT("5개 일치 (1,500,000원) - %d개"),
    FORTH_RANKING_OUTPUT("4개 일치 (50,000원) - %d개"),
    FIFTH_RANKING_OUTPUT("3개 일치 (5,000원) - %d개"),

    RATE_OF_PROFIT_OUTPUT1("총 수익률은 "),
    RATE_OF_PROFIT_OUTPUT2("%입니다."),

    SPLIT(","),
    RATE_OF_PROFIT_FORMAT("%.1f")
}