package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = Money()
    val message = Message()

    println(Message.INPUT_MONEY_MASSAGE)
    money.inputMoney()

    if (money.money == "ERROR") {
        return
    }

    val lotteryTickets = generateLotteryTickets(money.countLotteryTickets())
    message.printTickets(lotteryTickets.map { lotto -> lotto.getNumber() })

    println(Message.INPUT_WINNING_MASSAGE)
    val winningNumber = generateWinningNumber()
    Exceptions.checkWiningNumber(winningNumber)

    println(Message.INPUT_BONUS_MASSAGE)
    val bonus = generateBonusNumber()
    Exceptions.checkBonus(winningNumber, bonus)

    var winningResult = generateWinningResult(lotteryTickets, winningNumber, bonus)

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

fun generateWinningNumber(): List<String> {
    return Console.readLine()
        .trim()
        .split(",")
}

fun generateBonusNumber(): String {
    return Console.readLine().trim()
}

fun generateWinningResult(lotteryTickets: List<Lotto>, winningNumber: List<String>, bonus: String): MutableList<Int> {
    val winningResult = mutableListOf(0, 0, 0, 0, 0)
    lotteryTickets.forEach {
        val winning = it.checkWinning(winningNumber, bonus)
        if (winning in 0..4)
            winningResult[winning]++
    }
    return winningResult
}