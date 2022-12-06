package lotto

interface EnumErrorInterface {
    fun checkErrorType(type: ErrorType): String
}

class EnumError() : EnumErrorInterface {
    override fun checkErrorType(type: ErrorType): String {
        return when (type) {
            ErrorType.NotDivideWithThousand -> "입력된 수가 로또 구매 금액으로 나누어 떨어지지 않습니다."
            ErrorType.NotOnlyNumber -> "숫자가 아닌 문자가 포함되어 있습니다."
            ErrorType.NotEnoughLength -> "당첨 번호는 6개의 숫자와 , 로 이루어져야 합니다."
            ErrorType.NotInRange -> "로또 번호는 1부터 45 사이의 숫자여야 합니다."
            ErrorType.WinNumberListIsDuplicated -> "당첨 번호는 중복된 숫자일 수 없습니다."
            ErrorType.DuplicatedWithWinList -> "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            ErrorType.InputIsNull -> "입력값은 공백일 수 없습니다."
            ErrorType.NotMatchedToLottoLength -> "로또번호는 6자리여야 합니다."
            ErrorType.NotExpectedError -> "예기치 않은 오류가 발생했습니다."
        }
    }
}

enum class ErrorType() {
    NotDivideWithThousand,
    NotOnlyNumber,
    NotEnoughLength,
    NotInRange,
    WinNumberListIsDuplicated,
    DuplicatedWithWinList,
    InputIsNull,
    NotMatchedToLottoLength,
    NotExpectedError
}
