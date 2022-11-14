package lotto

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
}

fun printStart() {
    println(Output.PurchaseAmount.message)
}

fun inputPrice(): Int {
    val price = readLine()!!.toInt()

    if (price % 1000 != 0)
        throw IllegalArgumentException(Error.NotDivideThousand.message)

    return price / 1000
}

fun printCount(count: Int) {
    println("$count${Output.NumberOfPurchases.message}")
}