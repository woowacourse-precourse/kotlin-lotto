package lotto

import camp.nextstep.edu.missionutils.Console.readLine

class Buyer {
    private var winningNumbers = listOf<Int>()

    fun enterAmount(): Int {
        val input = readLine()
        input.apply {
            checkIsBlank(this)
            checkIsNumber(this)
            checkCanDivide(this)
            checkIsInIntRange(this)
        }
        return input.toInt()
    }

    fun enterWinningNumber() {
        val input = readLine()
        input.apply {
            checkIsBlank(this)
            checkIsRightFormat(this)
            checkIsNumberInRange(this)
            checkDuplicate(this)
        }
        winningNumbers = input.split(",").map { it.toInt() }
    }

    fun enterBonusNumber() {
        val input = readLine()
        checkIsBlank(input)
        checkIsIn1To45(input.toInt())
        checkDuplicateWithWinningNumber(input.toInt())
    }

    private fun checkIsBlank(input: String) {
        if (input.isBlank()) {
            Lottery.printAndThrowException(ENTER_AMOUNT)
        }
    }

    private fun checkIsNumber(input: String) {
        input.forEach {
            if (!it.isDigit()) {
                Lottery.printAndThrowException(ENTER_NUMBER)
            }
        }
    }

    private fun checkCanDivide(input: String) {
        if (!canDivide1000(input.toInt())) {
            Lottery.printAndThrowException(MUST_CAN_DIVIDED)
        }
    }

    private fun checkIsInIntRange(input: String) {
        if (input.toLong() > Int.MAX_VALUE) {
            Lottery.printAndThrowException(MAX_AMOUNT)
        }
    }

    private fun canDivide1000(num: Int) = num % ONE_THOUSAND == ZERO

    private fun checkIsRightFormat(input: String) {
        if (!(INPUT_FORMAT.toRegex().matches(input)))
            Lottery.printAndThrowException(FORMAT_ERROR)
    }

    private fun checkIsNumberInRange(input: String) {
        input.split(",").forEach {
            checkIsIn1To45(it.toInt())
            if (it[0] == '0')
                Lottery.printAndThrowException(WRONG_RANGE)
        }
    }

    private fun checkIsIn1To45(num: Int) {
        if (num !in (1..45))
            Lottery.printAndThrowException(WRONG_RANGE)
    }

    private fun checkDuplicate(input: String) {
        val numbers: Set<String> = input.split(",").toSet()
        if (numbers.count() != ONE_LOTTERY_COUNT)
            Lottery.printAndThrowException(DUPLICATE_NUMBER)
    }

    private fun checkDuplicateWithWinningNumber(num: Int) {
        if (winningNumbers.contains(num))
            Lottery.printAndThrowException(DUPLICATE_NUMBER)
    }

}