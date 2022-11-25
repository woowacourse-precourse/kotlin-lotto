package lotto

class UserInputPrice(private val userInput : String) {
    fun checkUserInputPriceRegexAndTranslateToInt(): Int {
        return if (Regex.userInputMoneyRegexes(userInput)) {
            Regex.changeStringToInt(userInput)
        } else INPUT_ERROR_CODE
    }
}