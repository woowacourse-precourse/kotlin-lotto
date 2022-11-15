package lotto

enum class UserInputTextType {
    PURCHASE_AMOUNT, LOTTO_NUMBERS, BONUS_NUMBER
}

fun exceptionsByUserInputTextType(
    userInputTextType: UserInputTextType, numbers: List<Int> = emptyList(), bonusNumber: Int = 0, paymentCost: Int = 0
) {

    when (userInputTextType) {
        UserInputTextType.PURCHASE_AMOUNT -> {
            handlingPurchaseAmountExceptions(paymentCost)
        }

        UserInputTextType.LOTTO_NUMBERS -> {
            handlingLottoNumberExceptions(numbers)
        }

        UserInputTextType.BONUS_NUMBER -> {
            handlingBonusNumberExceptions(bonusNumber, numbers)
        }

    }
}

fun handlingLottoNumberExceptions(numbers: List<Int>) {
    require(numbers.size == BaseNumber.LOTTO_NUMBER_COUNT.number) { LottoErrorText.ENTER_SIX_NUMBERS.errorText }
    require(numbers.distinct().size == 6) { LottoErrorText.ENTER_WITHOUT_DUPLICATES_DIGITS.errorText }
    require(numbers.filter { (BaseNumber.LOTTO_MIN_NUMBER.number..BaseNumber.LOTTO_MAX_NUMBER.number).contains(it) }.size == 6) { LottoErrorText.ENTER_ONLY_NUMBERS_FROM_ONE_TO_FORTY_FIVE.errorText }
}

fun handlingBonusNumberExceptions(number: Int, numbers: List<Int>) {
    require((1 until 45).contains(number)) { BonusNumberErrorText.ENTER_ONLY_NUMBERS_FROM_ONE_TO_FORTY_FIVE.errorText }
    require(!(numbers.contains(number))) { BonusNumberErrorText.ENTER_WITHOUT_DUPLICATES_DIGITS.errorText }
}

fun handlingPurchaseAmountExceptions(paymentCost: Int) {
    require(paymentCost % 1000 == 0) { PurchaseAmountErrorText.SET_UP_PAYMENT_UNIT.errorText }
}

