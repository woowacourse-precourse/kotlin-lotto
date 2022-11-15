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

    if (winningNumber.isEmpty())
        return

    val bonusNumber = userInput.inputBonusNumber(winningNumber)

    if (bonusNumber == "ERROR")
        return

    winningNumber.add(bonusNumber)

    LottoResult.getWinningResult(winningNumber.map { it.toInt() })
    LottoResult.print(money.toInt())
}
