package lotto

import kotlin.system.exitProcess

fun main() {
    val SIZE = getTotalLottoPrice()
}

fun getTotalLottoPrice(): Int {
    println("구입 금액을 입력해주세요.")
    try {
        val price = readLine()?.toInt() ?: throw IllegalArgumentException()
        if (price % 1000 != 0) throw IllegalArgumentException()
        println()
        return price/1000
    } catch(e: IllegalArgumentException) {
        println("[ERROR] 구입한 로또 가격 입력 오류")
        exitProcess(0)
    }
}
