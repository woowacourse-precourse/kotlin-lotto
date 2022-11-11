package lotto.utils

object ErrorMessage {
    private const val ERROR = "[ERROR] "
    const val INPUT_NOT_NUMBERS = ERROR.plus("로또 번호는 숫자로 입력해야 합니다.")
    const val INPUT_NOT_REMAINING_MONEY = ERROR.plus("적절한 입력 값이 아닙니다. 로또 개당 가격은 1,000원 입니다.")
    const val INPUT_EXIST_FIRST_WORD_ZERO = ERROR.plus("적절한 입력 값이 아닙니다. 첫 글자 0을 빼고 입력해주세요.")
}
