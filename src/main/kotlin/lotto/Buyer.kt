package lotto

import camp.nextstep.edu.missionutils.Console.readLine

class Buyer {
    fun enterAmount(): Int {
        val input = readLine()
        checkIsBlank(input)
        checkIsNumber(input)
        checkCanDivide(input)
        checkIsInIntRange(input)
        return input.toInt()
    }

    fun enterWinningNumber(): List<Int> {
        val input = readLine()
        checkIsRightFormat(input)
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

    private fun canDivide1000(num: Int) = num % 1000 == 0

    private fun checkIsRightFormat(input: String) {
        if (!"[1-45],[1-45],[1-45],[1-45],[1-45],[1-45]".toRegex().matches(input)) {
            Lottery.printAndThrowException("입력 형식에 맞게 입력해주세요.")
        }
    }
}