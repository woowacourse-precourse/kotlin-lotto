package lotto.data

object ErrorMessage {

    private const val ERROR = "[ERROR] "

    const val ERROR_NOT_NUMBERS = ERROR.plus("숫자를 입력해야 합니다.")
    const val ERROR_NOT_THOUSANDS = ERROR.plus("1000원 단위로 입력해야 합니다")
    const val ERROR_NUM_NOT_IN_RANGE = ERROR.plus("1 ~ 45 사이의 값을 입력해야 합니다.")
    const val ERROR_NUM_DUPLICATION = ERROR.plus("숫자가 중복되었습니다.")
    const val ERROR_NOT_COMMA = ERROR.plus("콤마로 숫자를 구분해야 합니다.")
    const val ERROR_BONUS_DUPLICATION_WITH_WIN = ERROR.plus("보너스와 당첨 숫자는 중복되면 안됩니다.")
}