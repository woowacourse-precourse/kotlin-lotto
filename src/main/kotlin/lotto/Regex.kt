package lotto

import java.util.regex.Pattern

object Regex {
    fun checkItCanDivideWithThousand(userInputPrice: Int): Boolean {
        return (userInputPrice % LOTTO_EACH_PRICE == 0)
    }

    fun checkItOnlyContainsNumber(userInput: String): Boolean {
        return Pattern.matches("^[0-9]*$", userInput)
    }
}