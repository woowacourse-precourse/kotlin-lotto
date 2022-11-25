package lotto

import java.util.regex.Pattern

object Regex {

    fun userInputMoneyRegexes(userInput: String): Boolean {
        return try {
            checkItOnlyContainsNumber(userInput)
            checkItCanDivideWithThousand(changeStringToInt(userInput))
            checkInputIsNull(userInput)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun userInputWinningRegexes(userInput: String): String {
        checkUserInputOnlyContainsNumber(userInput)
        checkUserWinNumberInputLength(userInput)
        getUserInputIsInRange(userInput)
        checkUserWinNumberInputIsNotDuplicated(userInput)
        return userInput
    }

    fun userInputBonusRegexes(userInput: String): Boolean {
        return try {
            checkUserInputOnlyContainsNumber(userInput)
            getUserInputIsInRange(userInput)
            checkInputIsNull(userInput)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun convertStringToList(input: String): List<String> {
        return input.split(",").filter { it != "" }
    }

    private fun checkItCanDivideWithThousand(userInputPrice: Int) {
        if (userInputPrice % LOTTO_EACH_PRICE != 0) {
            Error.showError(ErrorType.NotDivideWithThousand)
        }
    }

    private fun checkItOnlyContainsNumber(userInput: String) {
        if (!Pattern.matches("^[0-9]*$", userInput)) {
            Error.showError(ErrorType.NotOnlyNumber)
        }
    }

    private fun checkUserInputOnlyContainsNumber(userInput: String) {
        val numberList = convertStringToList(userInput)
        for (i in numberList) {
            checkItOnlyContainsNumber(i)
        }
    }

    private fun checkUserWinNumberInputLength(userInput: String) {
        if (convertStringToList(userInput).size != 6) {
            Error.showError(ErrorType.NotEnoughLength)
        }
    }

    private fun checkUserWinNumberInputIsNotDuplicated(userInput: String) {
        val userWinNumberList = convertStringToList(userInput)
        if (userWinNumberList.size != userWinNumberList.distinct().size) {
            Error.showError(ErrorType.WinNumberListIsDuplicated)
        }
    }

    private fun getUserInputIsInRange(userInput: String) {
        if (!checkUserInputIsInRange(userInput)) {
            Error.showError(ErrorType.NotInRange)
        }
    }

    private fun checkUserInputIsInRange(userInput: String): Boolean {
        val numberList = convertStringToList(userInput)
        for (i in numberList) {
            if (i.toInt() !in 1..45) {
                return false
            }
        }
        return true
    }

    fun checkIfBonusDuplicatedWithWinNumbers(WinNumbers: List<String>, BonusNumber: String): Boolean {
        return WinNumbers.contains(BonusNumber)
    }

    private fun checkInputIsNull(userInput: String) {
        if (userInput.isEmpty()) {
            Error.showError(ErrorType.InputIsNull)
        }
    }

    fun changeStringToInt(userInput: String): Int {
        return try {
            userInput.toInt()
        } catch (exception: Exception) {
            println(exception.message)
            return INPUT_ERROR_CODE
        }
    }
}