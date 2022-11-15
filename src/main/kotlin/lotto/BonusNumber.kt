package lotto
import lotto.ExceptionHandler.throwExceptionForBonusNumbers
class BonusNumber(private val bonusNumber: Int, private val lottoNumbers: List<Int>) {

    init {
        throwExceptionForBonusNumbers(bonusNumber, lottoNumbers)
    }

    fun getBonusNumber(): Int {
        return this.bonusNumber
    }

}