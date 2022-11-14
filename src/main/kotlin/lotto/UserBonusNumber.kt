package lotto

class UserBonusNumber(private val userWinNumbers: List<String>, private val userBonusNumber: String) {
    fun getBonusNumberRegex(): String {
        checkIsBonusNumberDuplicatedWithWinNumbers(userWinNumbers, userBonusNumber)
        checkUserBonusNumberRegex(userBonusNumber)
        return userBonusNumber
    }

    private fun checkUserBonusNumberRegex(userInput: String): Int {
        if (!Regex.checkUserInputOnlyContainsNumber(userInput)) {
            Error.showError(ErrorType.NotOnlyNumber)
        }
        if (!Regex.checkUserInputIsInRange(userInput)) {
            Error.showError(ErrorType.NotInRange)
        }
        if (!Regex.checkInputIsNull(userInput)) {
            Error.showError(ErrorType.InputIsNull)
        }
        return userInput.toInt()
    }

    private fun checkIsBonusNumberDuplicatedWithWinNumbers(WinNumberList: List<String>, BonusNumber: String) {
        if (Regex.checkIfBonusDuplicatedWithWinNumbers(WinNumberList, BonusNumber)) {
            Error.showError(ErrorType.DuplicatedWithWinList)
        }
    }
}