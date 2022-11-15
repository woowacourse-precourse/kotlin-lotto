package lotto.ui.view.ticket

import camp.nextstep.edu.missionutils.Console
import lotto.domain.common.ERROR_FORMAT
import lotto.domain.common.ERROR_TICKET_MONEY_MESSAGE
import lotto.ui.view.View

class BuyTicketView: View() {

    fun enterTicketMoney(): String {
        println(INPUT_TICKET_MONEY_MESSAGE)
        return Console.readLine().trim()
    }

    fun printTicketCountMessage(ticketCount: Int) {
        println(OUTPUT_TICKET_COUNT_MESSAGE.format(ticketCount))
    }

    fun printLottoNumberMessage(lottoNumbers: String) {
        println(OUTPUT_LOTTO_NUMBER_MESSAGE.format(lottoNumbers))
    }

    override fun printErrorMessage() {
        println(ERROR_FORMAT.format(ERROR_TICKET_MONEY_MESSAGE))
        throw java.lang.IllegalArgumentException()
    }


    companion object {
        private const val INPUT_TICKET_MONEY_MESSAGE = "구입금액을 입력해 주세요."
        private const val OUTPUT_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다."
        private const val OUTPUT_LOTTO_NUMBER_MESSAGE = "[%s]"
    }
}