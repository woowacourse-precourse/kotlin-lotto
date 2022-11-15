package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Message.Companion.NOT_INT_MESSAGE
import lotto.Message.Companion.NOT_THOUSANDS_NUMBER_MESSAGE
import lotto.Units.Companion.INIT_NUMBER
import lotto.Units.Companion.REMINDER
import lotto.Units.Companion.THOUSAND_UNIT

class Machine() {
    private var inputMoney = INIT_NUMBER
    private var ticket = INIT_NUMBER
    var issuedLottery = mutableListOf<List<Int>>()

    fun operate() {
        inputMoney = putinMoney()
        ticket = inputMoney / THOUSAND_UNIT
        issuedLottery = makeLottoNumbers(ticket)
    }

    private fun putinMoney(): Int {
        printInputMoney()
        val money = Console.readLine()
        moneyCheck(money)
        return money.toInt()
    }


    private fun makeLottoNumbers(ticket: Int): MutableList<List<Int>> {
        printButLotto(ticket)
        var lotteryCount = INIT_NUMBER
        while (lotteryCount < ticket) {
            issuedLottery += Lotto(Ticket().makeLottoTicket()).getNumbers()
            printTickets(issuedLottery, lotteryCount)
            lotteryCount++
        }
        return issuedLottery
    }

    private fun moneyCheck(money: String) {
        val priceRegex = "\\d+".toRegex()
        when {
            money.matches(priceRegex).not() -> printNotNumberErrorMessage()
            money.toInt() % THOUSAND_UNIT != REMINDER -> throw IllegalArgumentException(NOT_THOUSANDS_NUMBER_MESSAGE)
        }
    }
}
