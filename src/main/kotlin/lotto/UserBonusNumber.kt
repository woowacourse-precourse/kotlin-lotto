package lotto

class UserBonusNumber(private val userWinNumbers: List<String>, private val userBonusNumber: String) {
    fun getBonusNumberRegex(): String {
        checkIsBonusNumberDuplicatedWithWinNumbers(userWinNumbers, userBonusNumber)
        checkUserBonusNumberRegex(userBonusNumber)
        return userBonusNumber
    }

    private fun checkUserBonusNumberRegex(userInput: String): Int {
        try {
            Regex.userInputBonusRegexes(userInput)
        } catch (_ : Exception) {}
        return userInput.toInt()
    }

    private fun checkIsBonusNumberDuplicatedWithWinNumbers(WinNumberList: List<String>, BonusNumber: String) {
        if (Regex.checkIfBonusDuplicatedWithWinNumbers(WinNumberList, BonusNumber)) {
            Error.showError(ErrorType.DuplicatedWithWinList)
        }
    }
}