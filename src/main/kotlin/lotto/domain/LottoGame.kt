package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.Exceptions

const val GAME_START_MESSAGE = "구입금액을 입력해 주세요."

class LottoGame {
    fun start() {
        val playerCost = getCost()
        val playerTicket = getLottoTicket(playerCost)
    }

    private fun getCost(): Int {
        println(GAME_START_MESSAGE)
        return Console.readLine().toInt()
    }

    private fun getLottoTicket(cost: Int): List<Lotto> {
        return LottoGenerator(cost).generate()
    }
}