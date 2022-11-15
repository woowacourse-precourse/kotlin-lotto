package lotto.util

import java.util.regex.Matcher
import java.util.regex.Pattern

class InputValidable {
    fun checkInputMessagePatten(checkOverlap: MutableList<String>) {
        val regax = "^\\d*$"
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