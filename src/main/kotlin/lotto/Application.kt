package lotto

fun main() {
    printStart()
    val purchaseAmount = inputPrice()
}

fun printStart() {
    println(Output.PurchaseAmount.message)
}

fun inputPrice(): Int {
    val price = readLine()!!.toInt()

    if (price % 1000 != 0)
        throw IllegalArgumentException(Error.NotDivideThousand.message)

    return price
}
