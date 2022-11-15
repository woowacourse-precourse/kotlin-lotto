package lotto.model

enum class Strings(val reward: String) {
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - "),
    COUNT("개를 구매했습니다. "),
    INPUT_PURCHASE_CENTENCE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---\n"),

    Input_1000_Unit("[ERROR] 1000원 단위로 입력해주세요!"),
    Input_Only_Num("[ERROR] 숫자 형태로 입력해주세요!"),
    Input_Six_WinningNum("[ERROR] 6개의 당첨 번호를 입력해 주세요."),
    Input_Correct_Range("[ERROR] 1~45사이의 숫자를 입력해 주세요."),
    Input_EachOther_Num("[ERROR] 당첨 번호는 서로 다른 숫자로 입력해 주세요."),
    This_Duplicate_Num("[ERROR] 당첨 번호와 중복된 번호입니다.")



}