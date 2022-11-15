package lotto

class BonusNumberCheckError(private val bonusNumber: String, private val winningNumbers: Lotto) {
    fun checkBonusNumberThrowException() {
        throwBonusNumberFormException()
        throwBonusNumberRangeException()
        throwBonusNumberDuplicationException()
    }

    private fun throwBonusNumberFormException() {
        bonusNumber.forEach { char ->
            if (char !in '0'..'9') {
                println("[ERROR] 보너스 번호는 숫자만 입력 해야 합니다.")
                throw IllegalArgumentException()
            }
        }
    }

    private fun throwBonusNumberRangeException() {
        if (bonusNumber in "1".."45") {
            println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }

    private fun throwBonusNumberDuplicationException() {
        if (winningNumbers.getNumbers().contains(bonusNumber.toInt())) {
            println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
            throw IllegalArgumentException()
        }
    }
}
