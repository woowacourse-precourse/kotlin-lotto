package lotto

import camp.nextstep.edu.missionutils.Console.readLine

class Buyer {
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

    fun enterWinningNumber(): List<Int> {
        val input = readLine()
        input.apply {
            checkIsBlank(this)
            checkIsRightFormat(this)
            checkDuplicate(this)
        }
        return input.split(",").map { it.toInt() }
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
        if (!INPUT_FORMAT.toRegex().matches(input)) {
            Lottery.printAndThrowException(FORMAT_ERROR)
        }
    }

    private fun checkDuplicate(input: String) {
        val numbers: Set<String> = input.split(",").toSet()
        if (numbers.count() != ONE_LOTTERY_COUNT)
            Lottery.printAndThrowException(DUPLICATE_NUMBER)
    }

}