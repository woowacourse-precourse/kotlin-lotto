package lotto.domain

import camp.nextstep.edu.missionutils.Console

class LottoGame {
    fun start() {
        val playerCost = getCost()
        val playerTicket = getLottoTicket(playerCost)
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


    companion object {
        const val GAME_START_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_EXCEPTION = "잘못된 입력입니다."
    }
}