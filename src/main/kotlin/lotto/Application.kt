package lotto

fun main() {
    val money = Input().inputMoney()

    if (money == "ERROR")
        return

    val lotteryCount = money.toInt()/1000
    Lotto.createLotto(lotteryCount)
    Lotto.printLotto()
}
