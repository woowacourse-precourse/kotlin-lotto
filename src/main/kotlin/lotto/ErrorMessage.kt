package lotto

object ErrorMessage {

    private const val ERROR = "[ERROR] "

    const val ERROR_NOT_NUMBERS = ERROR.plus("숫자가 아닙니다.")
    const val ERROR_MESSAGE = ERROR.plus("에러가 발생했습니다.")
    const val ERROR_NOT_THOUSANDS = ERROR.plus("1000원 단위로 입력해야 합니다")
    const val ERROR_NUM_NOT_IN_RANGE = ERROR.plus("1 ~ 45 사이의 값을 입력해야 합니다.")
    const val ERROR_NUM_DUPLICATION = ERROR.plus("숫자가 중복되었습니다.")
}