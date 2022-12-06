package lotto

class UserWinNumbers(private val userInput: String) {
    fun checkUserWinNumberRegex(): List<String> {
        return Regex.userInputWinningRegexes(userInput).split(",").filter { it != "" }
    }
}