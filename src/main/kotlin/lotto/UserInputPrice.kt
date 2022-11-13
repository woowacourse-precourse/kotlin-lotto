package lotto

class UserInputPrice(private val userInput : String) {

    fun checkUserInputPriceRegexAndTranslateToInt(): Int {
        try {
            if (!Regex.checkItOnlyContainsNumber(userInput)) {
                Error.showError(ErrorType.NotOnlyNumber)
            }
            if (!Regex.checkItCanDivideWithThousand(changeStringToInt(userInput))) {
                Error.showError(ErrorType.NotDivideWithThousand)
            }
        } catch (exception: IllegalArgumentException) {
            println(exception)
        }
        return changeStringToInt(userInput)
    }

    private fun changeStringToInt(userInput: String): Int {
        return try {
            userInput.toInt()
        } catch (exception : Exception) {
            println(exception.message)
            return INPUT_ERROR_CODE
        }
    }
}