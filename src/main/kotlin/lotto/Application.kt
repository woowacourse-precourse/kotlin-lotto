package lotto


import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import java.lang.NullPointerException
import java.lang.NumberFormatException


fun main() {

    val lottoGame = LottoGame()

    try {
        lottoGame.start()
    } catch (e : IllegalArgumentException) {
        println(e.message)
        return
    }
}
