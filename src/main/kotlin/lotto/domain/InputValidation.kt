package lotto.domain


class InputValidation(val inputNumber: String) {
    enum class ErrorMessage(val sentence: String) {
        UNIT_ERROR("[ERROR] ${Lotto.ConstantVariable.LOTTO_PRICE.number}원 단위로 구매해야합니다."),
        BONUS_OVERLAP_ERROR("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
        LENGTH_ERROR("[ERROR] 로또 번호는 6자리 숫자여야 합니다."),
        OVERLAP_ERROR("[ERROR] 로또 번호는 서로 중복될 수 없습니다."),
        RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        LETTER_ERROR("[ERROR] 숫자 이외에는 입력할 수 없습니다.")
    }

    fun inputNumberExceptionCheck(): Boolean {
        checkLetter(inputNumber)
        checkUnit()
        return true
    }

    fun winningNumberExceptionCheck(): Boolean {
        val winningLine = inputNumber.split(',')
        checkLength(winningLine)
        for (number in winningLine) {
            checkLetter(number)
            checkRange(number.toInt())
        }
        return true
    }

    fun bonusNumberExceptionCheck(userNumber: Lotto): Boolean {
        checkLetter(inputNumber)
        checkRange(inputNumber.toInt())
        checkBonusOverlap(userNumber)
        return true
    }

    private fun checkUnit() {
        if (inputNumber.toInt() % Lotto.ConstantVariable.LOTTO_PRICE.number != 0) {
            throw IllegalArgumentException(ErrorMessage.UNIT_ERROR.sentence)
        }
    }

    private fun checkBonusOverlap(userNumber: Lotto) {
        if (userNumber.contains(inputNumber.toInt())) {
            throw IllegalArgumentException(ErrorMessage.BONUS_OVERLAP_ERROR.sentence)
        }
    }

    private fun checkLength(number: List<String>) {
        if (number.size != Lotto.ConstantVariable.LOTTO_SIZE.number) {
            throw IllegalArgumentException(ErrorMessage.LENGTH_ERROR.sentence)
        }
        if (number.toSet().size != Lotto.ConstantVariable.LOTTO_SIZE.number) {
            throw IllegalArgumentException(ErrorMessage.OVERLAP_ERROR.sentence)
        }
    }

    private fun checkLetter(number: String) {
        val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
        if (!number.matches(regexOnlyNumber)) {
            throw IllegalArgumentException(ErrorMessage.LETTER_ERROR.sentence)
        }
    }

    private fun checkRange(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException(ErrorMessage.RANGE_ERROR.sentence)
        }
    }
}