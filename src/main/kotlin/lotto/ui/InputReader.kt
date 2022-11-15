package lotto.ui

import camp.nextstep.edu.missionutils.Console

class InputReader {
    fun readNumber(): Int = try {
        readLine(" ").toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBER)
    }

    fun readNumbers(delimiters: String = ","): List<Int> = try {
        readLine(" ")
            .split(delimiters)
            .map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_DIVIDE_NUMBER_FORMAT.format(delimiters))
    }

    fun readLine(ignore: String = "") = Console.readLine()
        .replace(ignore, "")

    companion object {
        private const val ERROR_NOT_NUMBER = "숫자를 입력해주세요."
        private const val ERROR_DIVIDE_NUMBER_FORMAT = "숫자를 %s로 구분해서 입력해 주세요."
    }
}
