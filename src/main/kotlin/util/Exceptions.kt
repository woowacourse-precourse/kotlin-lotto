package util

object Exceptions {

    fun isValidInputMoney(money: String) {
        // 1000원으로 나누어 떨어져야함
        // 숫자만 들어가야한다
        val regex = "(^[1-9])([0-9]*)(0{3})(0*)".toRegex()
        if (!regex.matches(money)) {
            throw IllegalArgumentException(
                Messages.ERROR_MESSAGE +
                        Messages.ERROR_INVALID_INPUT_MESSAGE
            )
        }
    }

    // 로또번호가 중복되었는지 확인
    fun hasDuplicateNumbers(lotto: List<Int>) {
        if (lotto.size != lotto.toSet().size) {
            throw IllegalArgumentException(
                Messages.ERROR_MESSAGE +
                        Messages.ERROR_LOTTO_NUMBER_DUPLICATE
            )
        }
    }

    // 당첨번호의 문자 입력값 확인
    fun isValidWinningNumber(winningNumber: List<String>): List<Int> {
        return winningNumber.map { number ->
            try {
                number.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(
                    Messages.ERROR_MESSAGE +
                            Messages.ERROR_NUMBER_FORMAT
                )
            }
        }
    }

    // 당첨번호의 숫자 범위 예외 확인
    fun isValidRangeWinningNumber(winningNumber: List<Int>) {
        winningNumber.forEach { number ->
            if (number < Constants.RANGE_START || Constants.RANGE_END < number) {
                throw IllegalArgumentException(
                    Messages.ERROR_MESSAGE +
                            Messages.ERROR_NUMBER_RANGE
                )
            }
        }
    }
}