package lotto

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val money = Money()
    val message = Message()

    println(Message.INPUT_MONEY_MASSAGE)
    money.inputMoney()

    if (money.money == "ERROR") {
        return
    }

    val lotteryTickets = generateLotteryTickets(money.countLotteryTickets())
    message.printTickets(lotteryTickets.map{ lotto -> lotto.getNumber() })
}

fun generateLotteryTickets(num: Int): MutableList<Lotto> {
    val lotteryTicket = mutableListOf<Lotto>()
    for (i in 1..num) {
        lotteryTicket.add(Lotto(generateLottoNumber()))
    }
    return lotteryTicket
}

fun generateLottoNumber(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}