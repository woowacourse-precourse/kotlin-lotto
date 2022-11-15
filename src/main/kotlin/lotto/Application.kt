package lotto

fun main() {
    val userInput = Input()
    val money = userInput.inputMoney()

    if (money == "ERROR")
        return

    val lotteryCount = money.toInt()/1000
    Lotto.createLotto(lotteryCount)
    Lotto.printLotto()


    val winningNumber = userInput.inputWinningNumber().toMutableList()
    val bonusNumber = userInput.inputBonusNumber(winningNumber)
    winningNumber.add(bonusNumber)

    LottoResult.getWinningResult(winningNumber.map { it.toInt() })
    print("총 수익률은 ${LottoResult.calculateProfit(money.toInt())}%입니다.")
}
