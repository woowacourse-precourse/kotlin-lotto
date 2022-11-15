package lotto


import lotto.ErrorMessage.ERROR_MESSAGE

fun main() {
    try {
        LottoGames().startGame()
    }catch(e:IllegalArgumentException){
        println(ERROR_MESSAGE)
    }
}
