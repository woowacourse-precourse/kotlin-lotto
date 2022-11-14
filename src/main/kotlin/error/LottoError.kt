package error

enum class LottoError {
    OUT_OF_RANGE {
        override fun getErrorMessage() = "숫자가 범위를 벗어났습니다."
    },
    NUMBER_DUPLICATED {
        override fun getErrorMessage() = "중복되는 숫자가 존재합니다."
    },
    INCORRECT_NUMBER {
        override fun getErrorMessage()  = "숫자의 개수가 맞지 않습니다."
    },
    NUMBER_FORMAT_INCORRECT {
        override fun getErrorMessage() = "당첨 번호 입력 형식이 잘못되었습니다."
    },
    MONEY_UNIT_INCORRECT {
        override fun getErrorMessage() = "입력한 금액이 로또 값으로 나누어 떨어지지 않습니다."
    };

    abstract fun getErrorMessage(): String

    companion object {
        fun print(lottoError: LottoError) {
            println("[ERROR] ${lottoError.getErrorMessage()}")
        }
    }
}