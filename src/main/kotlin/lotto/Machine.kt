package lotto

import camp.nextstep.edu.missionutils.Console

class Machine() {
    private var inputMoney = 0
    private var ticket = 0
    var issuedLottery = mutableListOf<List<Int>>()

    fun operate() {
        inputMoney = putinMoney()
        ticket = inputMoney / 1000
        issuedLottery = makeLottoNumbers(ticket)
    }

    private fun putinMoney(): Int {
        println("구입 금액을 입력해주세요")
        val money = Console.readLine().toInt()
        if (money % 1000 != 0) throw IllegalArgumentException(NOT_THOUSANDS_NUMBER)
        return money
    }

    private fun makeLottoNumbers(ticket: Int): MutableList<List<Int>> {
        printButLottoMessage(ticket)
        var lotteryCount = 0
        while (lotteryCount < ticket) {
            issuedLottery += Lotto(Ticket().makeLottoTicket()).getNumbers()
            printTickets(issuedLottery, lotteryCount)
            lotteryCount++
        }
        return issuedLottery
    }

    private fun printButLottoMessage(count: Int) = println("${count}$BUY_LOTTO_MESSAGE")

    private fun printTickets(
        issuedLottery: MutableList<List<Int>>,
        lotteryCount: Int
    ) = println(issuedLottery[lotteryCount])

    companion object {
        const val NOT_THOUSANDS_NUMBER = "[ERROR] 입력된 금액이 1000원단위여야 합니다."
        const val BUY_LOTTO_MESSAGE = "개를 구매했습니다."
    }
}
