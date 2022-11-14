package lotto

fun main() {
    printStart()
    val price = inputPrice()
    if(price % 1000 != 0) throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.")
}

fun printStart() {
    println("구입금액을 입력해 주세요.")
}

fun inputPrice(): Int {
    return readLine()!!.toInt()
}
