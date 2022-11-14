package lotto


import camp.nextstep.edu.missionutils.Console
import java.lang.NullPointerException
import java.lang.NumberFormatException



fun main() {

    val inputView = InputView()
    val money = inputView.getInputMoney()
    val winningLotto = inputWinningLotto()
    val bonus = inputBonusNum()

    val lottoGenerate = LottoGenerate()
    val lotto = lottoGenerate.createLottos(money.getCountLotto())

    val lottos = Lottos(lotto)
    lottos.printLottos()
    lottos.printWinningResult(winningLotto!!, bonus.bonus, money.money)
}

fun inputWinningLotto(): Lotto? {
    println("당첨 번호를 입력해 주세요.")

    try {
        val numStr = Console.readLine().split(",")
        val nums = numStr!!.map { it.toInt() }
        return Lotto(nums)
    } catch (e: NullPointerException) {
        println("[ERROR] 당첨 번호를 입력하지 않았습니다.")
        throw IllegalArgumentException()
    } catch (e: NumberFormatException) {
        println("[ERROR] 당첨 번호에 올바른 값이 입력되지 않았습니다.")
        throw IllegalArgumentException()
    }
}

fun inputBonusNum(): Bonus {
    println("보너스 번호를 입력해 주세요.")

    try {
        return Bonus(Console.readLine())
    } catch (e : IllegalArgumentException) {
        e.printStackTrace()
        throw NoSuchElementException()
    }
}
