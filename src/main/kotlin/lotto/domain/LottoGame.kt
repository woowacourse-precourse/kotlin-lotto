package lotto.domain

import camp.nextstep.edu.missionutils.Console.readLine

class LottoGame {
    fun start() {
        val playerCost = getCost()
        val playerTicket = getLottoTicket(playerCost)
        printTicket(playerTicket)
        val winningNumbers = getWinningNumbers()
        val result = checkLotto(winningNumbers)
        printResult(result)
    }

    private fun getCost(): Int {
        println(GAME_START_MESSAGE)
        val playerInput = readLine()
        return validateNumberInput(playerInput)
    }

    private fun getLottoTicket(cost: Int): List<Lotto> {
        return LottoMachine(cost).generate()
    }


    private fun printTicket(playerTickets: List<Lotto>) {
        for (ticket in playerTickets) {
            println("[${ticket.toStr()}]")
        }
    }

    private fun getWinningNumbers(): WinningNumber {
        println(REQUEST_WINNING_NUMBER_MESSAGE)
        var input = readLine()
        val winningNumbers = validateNumbersInput(input)
        println(REQUEST_BONUS_NUMBER_MESSAGE)
        input = readLine()
        val bonusNumber = validateNumberInput(input)

        return WinningNumber(winningNumbers, bonusNumber)
    }


    private fun checkLotto(winningNumbers: Pair<List<Int>, Int>, tickets: List<Lotto>): List<Int> {
        return LottoResult().getResult()
    }

    private fun printResult(result: List<Int>) {
        LottoResult().printResult(result)
    }

    private fun validateNumberInput(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INPUT_EXCEPTION)
        }
    }

    private fun validateNumbersInput(input: String): List<Int>{
        val inputs = input.split((","))
        try {
            return inputs.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INPUT_EXCEPTION)
        }
    }

    companion object {
        const val GAME_START_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_EXCEPTION = "[ERROR] 잘못된 입력입니다. 숫자만을 입력해주세요"
        const val REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

    }
}