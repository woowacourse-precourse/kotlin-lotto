package lotto

object LottoMessage {
    // Lotto
    const val LOTTERY_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다."

    // WinningLottery
    const val NO_DUPLICATED_WITH_BONUS = "[ERROR] 당첨번호와 보너스볼에 중복된 번호가 있으면 안됩니다."

    // InputView
    const val PURCHASE_AMOUNT = "구입금액을 입력해 주세요. 이상한 값을 넣으면 [ERROR] 메시지가 뜹니다"
    const val MINIMUM_PURCHASE_AMOUNT_ERROR = "[ERROR] 구입금액은 최소 1000원 최대 2147483000원 입니다."
    const val NUMBER_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."
    const val WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    const val WINNING_NUMBER_FORMAT_ERROR = "[ERROR] 당첨번호는 \"1,2,3,4,5,6\" 같은 형식이어야 합니다."
    const val BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    // OutputView
    const val WINNING_STATS = "당첨 통계\n---"
    const val DECIMAL_FORMAT = "###,###"
    const val TOTAL_RETURN_FRONT = "총 수익률은"
    const val TOTAL_RETURN_END = "%입니다.\n"
    const val NUMBER_MATCH = "개 일치"
    const val BONUS_NUMBER_MATCH = "보너스 볼 일치"
    const val WON = "원"
    const val EA = "개"

    // Lotto, WinningLottery
    const val BONUS_RANGE_ERROR = "[ERROR] 보너스볼 번호는 1부터 45 사이의 숫자여야 합니다."
    const val LOTTERY_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
}
