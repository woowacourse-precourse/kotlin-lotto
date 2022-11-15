package exception

import util.Error
import java.util.NoSuchElementException

class ExceptionCheck {
    fun checkValidPrice(userInput: String): String {
        when {
            checkValidInputType(userInput) -> {
                println(Error.INPUT_TYPE_ERROR.message)
                throw NoSuchElementException()
            }
            userInput.toInt() % 1000 != 0 -> {
                println(Error.INPUT_UNIT_ERROR.message)
                throw IllegalArgumentException()
            }
            else -> {
                return userInput
            }
        }
    }

    fun checkValidWinningNumbers(userInput: String): List<Int> {
        val userInputNumber = userInput.split(",").map { it.toInt() }
        when {
            checkValidInputType(userInput) -> {
                println(Error.INPUT_TYPE_ERROR.message)
                throw IllegalArgumentException()
            }
            checkValidNumberRange(userInput) -> {
                println(Error.INPUT_RANGE_ERROR.message)
                throw IllegalArgumentException()
            }
            userInputNumber.size != 6 -> {
                println(Error.INPUT_SIX_NUMBER_ERROR.message)
                throw IllegalArgumentException()
            }
            else -> {
                return userInputNumber
            }
        }
    }

    fun checkValidBonusNumber(userInput: String): String {
        when {
            checkValidInputType(userInput) -> {
                println(Error.INPUT_TYPE_ERROR.message)
                throw IllegalArgumentException()
            }
            checkValidNumberRange(userInput) -> {
                println(Error.INPUT_RANGE_ERROR.message)
                throw IllegalArgumentException()
            }
            userInput.length != 1 -> {
                println(Error.INPUT_ONE_NUMBER_ERROR.message)
                throw IllegalArgumentException()
            }
            else -> {
                return userInput
            }
        }
    }
}