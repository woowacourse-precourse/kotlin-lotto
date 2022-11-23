package lotto.domain

import lotto.enums.ErrorMessages

object LottoShopChecker {

    fun checkPurchasingAmount(purchasingAmount: String) {
        require(purchasingAmount.all { it.isDigit() }) { ErrorMessages.DIGIT_EXCEPTION }
        require(purchasingAmount.toInt() % 1000 == 0) { ErrorMessages.REMAINDER_EXCEPTION }
    }

    fun checkBonusNumber(winningNumbers: Lotto, bonusNumber: String) {
        require(bonusNumber.all { it.isDigit() }) { ErrorMessages.DIGIT_EXCEPTION }
        require(bonusNumber.toInt() in 1..45) { ErrorMessages.RANGE_EXCEPTION }
        require(!winningNumbers.contains(bonusNumber.toInt())) { ErrorMessages.DISTINCT_EXCEPTION }
    }
}