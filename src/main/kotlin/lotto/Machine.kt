package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Message.Companion.NOT_THOUSANDS_NUMBER
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
        printInputMoneyMessage()
        val money = Console.readLine().toInt()
        moneyUnitCheck(money)
        return money
    }

    private fun makeLottoNumbers(ticket: Int): MutableList<List<Int>> {
        printButLottoMessage(ticket)
        var lotteryCount = INIT_NUMBER
        while (lotteryCount < ticket) {
            issuedLottery += Lotto(Ticket().makeLottoTicket()).getNumbers()
            printTickets(issuedLottery, lotteryCount)
            lotteryCount++
        }
        return issuedLottery
    }

    private fun moneyUnitCheck(money: Int) {
        if (money % THOUSAND_UNIT != REMINDER) throw IllegalArgumentException(NOT_THOUSANDS_NUMBER)
    }

}
