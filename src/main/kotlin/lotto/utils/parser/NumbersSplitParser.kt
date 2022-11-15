package lotto.utils.parser

class NumbersSplitParser {
    fun parse(input: String): List<String> {
        return input.split(",")
    }
}