package lotto.util

import java.util.regex.Matcher
import java.util.regex.Pattern

interface InputValidate{
    fun checkInputMessagePatten(checkOverlap: MutableList<String>)

    }
class InputValidateReal :InputValidate{
    override fun checkInputMessagePatten(checkOverlap: MutableList<String>) {
        val regax = "^[0-9]*$"
        val pattern: Pattern = Pattern.compile(regax)
        for (inputNum in checkOverlap) {
            val matcher: Matcher = pattern.matcher(inputNum)
            if (matcher.find().toString() == "false") {
                println("[ERROR]")
                throw IllegalArgumentException()
            }
        }
    }
}