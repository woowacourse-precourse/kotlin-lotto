package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

fun main() {
    printStart()
    val numberOfLotto = inputPrice()
    println()

    printCount(numberOfLotto)
    val lottos = MakeLottos().getLottos(numberOfLotto)
    println()

    val winningNumber = MakeLottos().winningNumber()
    println()

    val bonusNumber = MakeLottos().bonusNumber(winningNumber)
    println()

    val result = ResultLotto().result(lottos, winningNumber, bonusNumber)
    printEarningRate(result, numberOfLotto)
}

fun printEarningRate(money: Long, numberOfLotto: Int) {
    val rate = (money.toDouble() / (numberOfLotto.toDouble() * 1000) * 100)
    val format = String.format("%.1f", rate)
    print("${Output.EarningRate.message}$format%입니다.")
}

fun printStart() {
    println(Output.PurchaseAmount.message)
}

fun inputPrice(): Int {
    val price = Console.readLine()

    try {
        if (price.toInt() % 1000 != 0)
            throw IllegalArgumentException(Error.NotDivideThousand.message)
    } catch (e: NumberFormatException) {
        throw NumberFormatException(Error.NotNumber.message)
    }


    return price.toInt() / 1000
}

fun printCount(count: Int) {
    println("$count${Output.NumberOfPurchases.message}")
}