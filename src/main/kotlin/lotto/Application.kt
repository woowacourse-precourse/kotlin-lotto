package lotto

fun main() {
    try {
        LottoGames().startGame()
    }catch(e:IllegalArgumentException){
        println(e.message)
    }
}
