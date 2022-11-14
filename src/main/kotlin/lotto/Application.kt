package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = Money()
    val message = Message()
    val lottoList = LottoList()

    println(Message.INPUT_MONEY_MASSAGE)
    money.inputMoney()
    if (money.money == "ERROR") {
        return
    }

    lottoList.repeatAddition(money.getNumberOfPurchases())
    message.printLottoList(lottoList.getAllLottoNumber())

    println(Message.INPUT_WINNING_MASSAGE)
    val winningNumber = inputWinningNumber()
    Exceptions.checkWiningNumber(winningNumber)

    println(Message.INPUT_BONUS_MASSAGE)
    val bonus = inputBonusNumber()
    Exceptions.checkBonus(winningNumber, bonus)

    var winningResult = lottoList.getWinningResult(winningNumber, bonus)
    message.printStatistics(winningResult)

    val profitRate = money.getProfitRate(winningResult)
    message.printProfit(profitRate)

}

fun inputWinningNumber(): List<String> {
    return Console.readLine()
        .replace(" ", "")
        .split(",")
}

fun inputBonusNumber(): String {
    return Console.readLine().trim()
}
