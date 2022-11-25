package lotto

class UserBonusNumber(private val userWinNumbers: List<String>, private val userBonusNumber: String) {
    fun getBonusNumberRegex(): String {
        checkIsBonusNumberDuplicatedWithWinNumbers(userWinNumbers, userBonusNumber)
        checkUserBonusNumberRegex(userBonusNumber)
        return userBonusNumber
    }

    private fun checkUserBonusNumberRegex(userInput: String): Int {
        return if(Regex.userInputBonusRegexes(userInput)) {
            userInput.toInt()
        } else {
            INPUT_ERROR_CODE
        }
    }

    private fun checkIsBonusNumberDuplicatedWithWinNumbers(WinNumberList: List<String>, BonusNumber: String) {
        if (Regex.checkIfBonusDuplicatedWithWinNumbers(WinNumberList, BonusNumber)) {
            Error.showError(ErrorType.DuplicatedWithWinList)
        }
    }
}