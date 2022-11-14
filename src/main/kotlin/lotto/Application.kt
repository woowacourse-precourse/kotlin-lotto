package lotto

fun main() {
    val money = Money()
    val message = Message()
    val lottoList = LottoList()
    val input = Input()

    println(Message.INPUT_MONEY_MASSAGE)
    money.money = input.inputMoney()
    if (money.money == "ERROR") {
        return
    }

    lottoList.repeatAddition(money.getNumberOfPurchases())
    message.printLottoList(lottoList.getAllLottoNumber())

    println(Message.INPUT_WINNING_MASSAGE)
    val winningNumber = input.inputWinningNumber()

    println(Message.INPUT_BONUS_MASSAGE)
    val bonus = input.inputBonusNumber(winningNumber)


    var winningResult = lottoList.getWinningResult(winningNumber, bonus)
    message.printStatistics(winningResult)

    val profitRate = money.getProfitRate(winningResult)
    message.printProfit(profitRate)

}

