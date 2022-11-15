package lotto

class BonusNumber(private val bonusNumber: String, winningNumbers: Lotto) {
    init {
        BonusNumberCheckError(bonusNumber, winningNumbers).checkBonusNumberThrowException()
    }

    fun getBonusNumber() = bonusNumber.toInt()
}
