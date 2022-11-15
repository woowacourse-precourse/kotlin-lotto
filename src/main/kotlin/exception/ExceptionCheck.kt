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
}