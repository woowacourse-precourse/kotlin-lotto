package lotto

interface EnumErrorInterface {
    fun checkErrorType(type: Int) : String
}

enum class EnumError(
) : EnumErrorInterface {
    ErrorType {
        override fun checkErrorType(type: Int) : String{
            return when(type) {
                lotto.ErrorType.NotDivideWithThousand.errorType -> ErrorMsg.NotDivideWithThousand.errorMessage
                lotto.ErrorType.NotOnlyNumber.errorType -> ErrorMsg.NotOnlyNumber.errorMessage

                else -> ErrorMsg.NotExpectedError.errorMessage
            }
        }
    }
}

enum class ErrorMsg (
    val errorMessage : String
        ) {
    NotDivideWithThousand("입력된 수가 로또 구매 금액으로 나누어 떨어지지 않습니다."),
    NotOnlyNumber("숫자가 아닌 문자가 포함되어 있습니다."),
    NotExpectedError("예기치 않은 오류가 발생했습니다.")
}

enum class ErrorType(
    val errorType : Int
) {
    NotDivideWithThousand(0),
    NotOnlyNumber(1),
    NotExpectedError(100)
}
