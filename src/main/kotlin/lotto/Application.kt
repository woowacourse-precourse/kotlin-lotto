package lotto

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main() {

    val lottoGenerate = LottoGenerate()
    val lotto = lottoGenerate.createLottoNumbers()

    val money = inputMoney()
}

fun inputMoney() : Int {
    println("구입금액을 입력해 주세요.")

    var money = 0

    try {
        money = readLine()!!.toInt()
    } catch (e : NumberFormatException) {
        println("[ERROR] 입력 금액이 올바르지 않습니다.")
    }

    require(money % 1000 == 0) { "[ERROR] 입력 금액이 1000원으로 나누어 떨어져야합니다." }

    return money
}
