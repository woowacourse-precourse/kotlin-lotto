package lotto


class UserWinNumbers(private val userInput: String) {
    fun checkUserWinNumberRegex(): List<String> {
        if (!Regex.checkUserInputOnlyContainsNumber(userInput)) {
            Error.showError(ErrorType.NotOnlyNumber)
        }
        if (!Regex.checkUserWinNumberInputLength(userInput)) {
            Error.showError(ErrorType.NotEnoughLength)
        }
        if (!Regex.checkUserInputIsInRange(userInput)) {
            Error.showError(ErrorType.NotInRange)
        }
        if (!Regex.checkUserWinNumberInputIsNotDuplicated(userInput)) {
            Error.showError(ErrorType.WinNumberListIsDuplicated)
        }
        return userInput.split(",").filter { it != "" }
    }
}