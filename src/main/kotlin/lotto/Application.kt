package lotto

fun main() {
    val lottoGame = LottoGame()
    try {
        lottoGame.gameStart()
    } catch (e: Exception) {
        println(e.message)
    }
}
