package lotto


import java.lang.NullPointerException
import java.lang.NumberFormatException
import kotlin.NoSuchElementException
import kotlin.math.round

fun main() {

    val money = inputMoney()
    val winningLotto = inputWinningLotto()
    val bonus = inputBonusNum()

    val lottoGenerate = LottoGenerate()
    val lotto = lottoGenerate.createLottos(money.getCountLotto())
    val lottos = Lottos(lotto)
    lottos.printLottos()
    lottos.printWinningResult(winningLotto!!, bonus!!, money.money)
}

fun inputMoney() : Money {
    println("구입금액을 입력해 주세요.")
    val money = readLine()
    require(money != null) { println("[ERROR] 구입금액을 입력하지 않았습니다.") }
    return Money(money)
}

fun inputWinningLotto(): Lotto? {
    println("당첨 번호를 입력해 주세요.")

    try {
        val numStr = readLine()?.split(",")
        val num = numStr!!.map { it.toInt() }
        return Lotto(num)
    } catch (e: NullPointerException) {
        println("[ERROR] 당첨 번호를 입력하지 않았습니다.")
    } catch (e: NumberFormatException) {
        println("[ERROR] 당첨 번호에 올바른 값이 입력되지 않았습니다.")
    }
    return null
}

fun inputBonusNum(): Int? {
    println("보너스 번호를 입력해 주세요.")

    try {
        val bonus = readLine()?.toInt()
        require(bonus!! >= 1 && bonus <= 45) { "[ERROR] 보너스 번호는 1에서 45사이의 값이여야 합니다." }
        return bonus
    } catch (e: NullPointerException) {
        //throw IllegalArgumentException("[ERROR] 보너스 번호를 입력하지 않았습니다.")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 보너스 번호가 올바르게 입력되지 않았습니다.")
    }
    return null
}
