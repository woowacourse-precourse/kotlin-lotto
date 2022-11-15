package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object Winning {
    private fun wordToNumber(word: String) = word.toInt()

    private fun wordsToNumber(words: List<String>): MutableList<Int> {
        val number = mutableListOf<Int>()

        for (i in words.indices)
            number.add(wordToNumber(words[i]))

        return number
    }

    private fun splitToWinningNumberPattern(string: String) = string.split(",")

    private fun isRightPatternOfWinningNumber(string: String) {
        if (splitToWinningNumberPattern(string).isNullOrEmpty() == null)
            throw IllegalArgumentException("[ERROR] 당첨 번호는 정해진 입력 형식(쉼표 구분)을 지켜야 합니다.")
    }

    private fun isNumberOfWinningNumber(string: String) {
        val number = splitToWinningNumberPattern(string)

        for (i in number.indices)
            Price.isNumber(number[i])
    }

    private fun isRightRangeOfWinningBonusNumber(string: String) {
        if (string.toInt() !in 1..45)
            throw IllegalArgumentException("[ERROR] 당첨 번호(보너스 번호)는 1부터 45까지의 수여야 합니다.")
    }

    private fun isRightRangeOfWinningNumber(string: String) {
        val number = splitToWinningNumberPattern(string)

        for (i in number.indices)
            isRightRangeOfWinningBonusNumber(number[i])
    }

    private fun isRightCountOfWinningNumber(string: String) {
        val number = splitToWinningNumberPattern(string)

        if (number.size != 6)
            throw IllegalArgumentException("[ERROR] 당첨 번호는 6개의 수여야 합니다.")
    }

    private fun isNotDuplicateOfWinningNumber(string: String) {
        val number = splitToWinningNumberPattern(string)

        if (number.size != number.distinct().size)
            throw IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 수여야 합니다.")
    }

    private fun isNotDuplicateOfBonusNumber(string: String, winningNumber: MutableList<Int>) {
        if (winningNumber.contains(string.toInt()))
            throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 수여야 합니다.")
    }

    private fun isSatisfyWinningNumberConditions(string: String) {
        isRightPatternOfWinningNumber(string)
        isNumberOfWinningNumber(string)
        isRightRangeOfWinningNumber(string)
        isRightCountOfWinningNumber(string)
        isNotDuplicateOfWinningNumber(string)
    }

    private fun isSatisfyBonusNumberConditions(string: String, winningNumber: MutableList<Int>) {
        Price.isNumber(string)
        isRightRangeOfWinningBonusNumber(string)
        isNotDuplicateOfBonusNumber(string, winningNumber)
    }

    private fun printEnterWinningNumberMessage() = println("당첨 번호를 입력해 주세요.")

    private fun printEnterBonusNumberMessage() = println("보너스 번호를 입력해 주세요.")

    private fun enterWinningNumber(): String {
        printEnterWinningNumberMessage()

        return Console.readLine()
    }

    private fun enterBonusNumber(): String {
        printEnterBonusNumberMessage()

        return Console.readLine()
    }

    private fun getWinningNumberOnly(): MutableList<Int> {
        val winningNumber = enterWinningNumber()

        isSatisfyWinningNumberConditions(winningNumber)

        return wordsToNumber(splitToWinningNumberPattern(winningNumber))
    }

    fun getWinningBonusNumbers(): MutableList<Int> {
        val winningNumber = getWinningNumberOnly()
        val bonusNumber = enterBonusNumber()

        isSatisfyBonusNumberConditions(bonusNumber, winningNumber)
        winningNumber.add(wordToNumber(bonusNumber))

        return winningNumber
    }
}