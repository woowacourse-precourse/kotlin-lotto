package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round






fun main() {
    try {
        val game = GameStart()
        game.gameStart()
    }
    catch(error:Exception){
        println(error.message)
    }
}
