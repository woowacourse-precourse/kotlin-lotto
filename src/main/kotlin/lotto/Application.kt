package lotto

fun main() {
    val money = Money()
    val message = Message()
    val lottoList = LottoList()
    val input = Input()

    println(Message.INPUT_MONEY_MASSAGE)
    money.money = input.inputMoney()
    if (money.isError()) {
        return
    }

    lottoList.repeatAddition(money.getNumberOfPurchases())
    message.printLottoList(lottoList.getAllLottoNumber())

    println(Message.INPUT_WINNING_MASSAGE)
    val winningNumber = input.inputWinningNumber()
    if (winningNumber.isEmpty()) {
        return
    }

    println(Message.INPUT_BONUS_MASSAGE)
    val bonus = input.inputBonusNumber(winningNumber)
    if (bonus == "ERROR") {
        return
    }

    val winningResult = lottoList.getWinningResult(winningNumber, bonus)
    message.printStatistics(winningResult)

    val profitRate = money.getProfitRate(winningResult)
    message.printProfit(profitRate)

}

