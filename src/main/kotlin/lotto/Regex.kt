package lotto

import java.util.regex.Pattern

object Regex {
    private fun convertStringToList(input : String) : List<String> {
        return input.split(",").filter { it != "" }
    }

    fun checkItCanDivideWithThousand(userInputPrice: Int): Boolean {
        return (userInputPrice % LOTTO_EACH_PRICE == 0)
    }

    fun checkItOnlyContainsNumber(userInput: String): Boolean {
        return Pattern.matches("^[0-9]*$", userInput)
    }

    fun checkUserInputOnlyContainsNumber(userInput: String): Boolean {
        val numberList = convertStringToList(userInput)
        for (i in numberList) {
            if (!checkItOnlyContainsNumber(i)) {
                return false
            }
        }
        return true
    }

    fun checkUserWinNumberInputLength(userInput: String): Boolean {
        return convertStringToList(userInput).size == 6
    }

    fun checkUserWinNumberInputIsNotDuplicated(userInput: String) : Boolean {
        val userWinNumberList = convertStringToList(userInput)
        return userWinNumberList.size == userWinNumberList.distinct().size
    }

    fun checkUserInputIsInRange(userInput: String): Boolean {
        val numberList = convertStringToList(userInput)
        for (i in numberList) {
            if (i.toInt() !in 1..45) {
                return false
            }
        }
        return true
    }
}