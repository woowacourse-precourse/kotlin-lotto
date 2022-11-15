package lotto.utils

object ErrorMessage {
    private const val ERROR = "[ERROR] "

    /** 입력 받은 구입금액 에러 메시지*/
    const val ERROR_NOT_NUMBERS = ERROR.plus("유효한 숫자가 아닙니다.")
    const val ERROR_REMAINING_MONEY = ERROR.plus("적절한 입력 값이 아닙니다. 로또 개당 가격은 1,000원 입니다.")

    /** 입력 받은 당첨금액, 보너스 에러 메시지  */
    const val ERROR_NUMBER_SIZE_OVER = ERROR.plus("입력하신 당첨 번호를 다시 확인해주세요. [ex. 1,2,3,4,5,6]")
    const val ERROR_NUMBER_DUPLICATE = ERROR.plus("복권 숫자에 중복값이 존재합니다.")
    const val ERROR_NOT_NUMBER_IN_RANGE = ERROR.plus("복권 숫자는 1부터 45 이내의 숫자만 가능합니다.")
    const val ERROR_CONTAIN_HALF_SPOT = ERROR.plus("입력한 당점번호 끝에 반점이 있습니다.")

    const val ERROR_NOT_VALID = ERROR.plus("유효한 값이 없습니다.")
}
