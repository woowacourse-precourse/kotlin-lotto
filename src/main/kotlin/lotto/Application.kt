package lotto

fun main() {
    try {
        val lottoGame = LottoGameStarter()
        lottoGame.gameStarter()
    } catch (e: Exception) {
        println(e.message)
    }
}
