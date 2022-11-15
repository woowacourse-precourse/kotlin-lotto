package lotto

import lotto.domain.Game

fun main() {
    try {
        val game=Game()
        game.start()
    }catch (e: IllegalArgumentException){
        println(e.message)
    }
}
