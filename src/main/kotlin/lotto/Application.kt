package lotto

import java.lang.IllegalArgumentException
import java.lang.NullPointerException
import java.lang.NumberFormatException

fun main() {

    val lottoGenerate = LottoGenerate()
    val lotto = lottoGenerate.createLottoNumbers()

    val money = inputMoney()
    val winningLotto = inputWinningLotto()
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

fun inputWinningLotto() : Lotto? {
    println("당첨 번호를 입력해 주세요.")

    try {
        val numStr = readLine()?.split(",")
        val num = numStr!!.map { it.toInt() }
        return Lotto(num)
    } catch( e : NullPointerException) {
        println("[ERROR] 당첨 번호를 입력하지 않았습니다.")
    } catch( e : NumberFormatException) {
        println("[ERROR] 당첨 번호에 올바른 값이 입력되지 않았습니다.")
    }
    return null
}
