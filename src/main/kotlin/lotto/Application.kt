package lotto

fun main() {
    printStart()
    val price = inputPrice()
}

fun printStart() {
    println("구입금액을 입력해 주세요.")
}

fun inputPrice(): Int {
    return readLine()!!.toInt()
}
