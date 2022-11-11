package lotto.ui.view.ticket

import camp.nextstep.edu.missionutils.Console

class BuyTicketView {

    fun enterTicketMoney(): String {
        println(INPUT_TICKET_MONEY_MESSAGE)
        return Console.readLine()
    }

    fun printBuyTicketMessage(money: String) {
        println(OUTPUT_BUY_TICKET_MESSAGE.format(money))
    }

    companion object {
        private const val INPUT_TICKET_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        private const val OUTPUT_BUY_TICKET_MESSAGE = "%d개를 구매했습니다."
    }
}