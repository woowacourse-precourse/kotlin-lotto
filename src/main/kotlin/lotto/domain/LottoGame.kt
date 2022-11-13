package lotto.domain

import camp.nextstep.edu.missionutils.Console.readLine

class LottoGame {
    fun start() {
        val playerCost = getCost()
        val playerTicket = getLottoTicket(playerCost)
        printTicket(playerTicket)
        val winningNumbers = getWinningNumbers()
        val result = getLottoResult(winningNumbers, playerTicket)
        printResult(result, playerCost)
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


    private fun getLottoResult(winningNumbers: WinningNumber, playerTickets: List<Lotto>): Map<String, Int> {
        return LottoResult().getResult(winningNumbers, playerTickets)
    }

    private fun printResult(result: Map<String, Int>, playerCost: Int) {
        LottoResult().printResult(result, playerCost)
    }

    private fun validateNumberInput(input: String): Int {
        val num = input.toIntOrNull()
        if (num == null) {
            println(INPUT_EXCEPTION)
            throw IllegalArgumentException(INPUT_EXCEPTION)
        }
        return num
    }

    private fun validateNumbersInput(input: String): List<Int> {
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