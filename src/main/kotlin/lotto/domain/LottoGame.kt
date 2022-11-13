package lotto.domain

import camp.nextstep.edu.missionutils.Console

class LottoGame {
    fun start() {
        val playerCost = getCost()
        val playerTicket = getLottoTicket(playerCost)
        printTicket(playerTicket)
        val winningNumbers = getWinningNumbers()
        val result = checkLotto(winningNumbers, playerTicket)
        printResult(result)
    }

    private fun getCost(): Int {
        println(GAME_START_MESSAGE)
        val playerInput = Console.readLine()
        try {
            return playerInput.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INPUT_EXCEPTION)
        }
    }

    private fun getLottoTicket(cost: Int): List<Lotto> {
        return LottoMachine(cost).generate()
    }


    private fun printTicket(playerTickets: List<Lotto>) {
        for (ticket in playerTickets) {
            println("[${ticket.toStr()}]")
        }
    }

    private fun getWinningNumbers(): Pair<List<Int>, Int> {
        return WinningNumber().generate()
    }

    private fun checkLotto(winningNumbers: Pair<List<Int>, Int>, tickets: List<Lotto>): List<Int> {
        return LottoResult().getResult()
    }

    private fun printResult(result: List<Int>) {
        LottoResult().printResult(result)
    }



    companion object {
        const val GAME_START_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_EXCEPTION = "잘못된 입력입니다."
    }
}