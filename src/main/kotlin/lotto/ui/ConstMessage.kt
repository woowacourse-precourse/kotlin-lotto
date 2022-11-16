package lotto.ui

object ConstMessage {
    //EXCEPTION
    const val UNIT_OF_MONEY_EXCEPTION = "천원으로 나누어 떨어지지 않는 숫자입니다."
    const val NON_NUMBER_EXCEPTION = "숫자가 아닙니다."
    const val LESS_MONEY_EXCEPTION = "천원보다 적은 숫자 입니다."
    const val OUT_OF_RANGE_EXCEPTION = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ENTER_MORE_NUMBER_EXCEPTION = "로또 번호의 개수가 6개 보다 많습니다."
    const val ENTER_DUPLICATION_NUMBER_EXCEPTION = "로또 번호에 중복된 숫자가 있습니다."

    //ConstMessage
    const val ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요."
    const val ENTER_WIN_NUMBER = "\n당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    const val WIN_STATS = "\n당첨 통계\n" + "---\n"
}