package lotto

import util.Game
import result.WinningResult
import user.UserInput

fun main() {
    playGame()
}

private fun playGame() {
    println(Game.PRICE_INPUT.message)
    val lottoPrice = UserInput().getUserPrice()
    val lottoCount = lottoPrice.toInt() / 1000
    val lottoNumbersList = RandomLottoNumbers().printLottoNumbers(lottoCount)
    println(Game.WINNING_NUMBERS_INPUT.message)
    val winningNumbers = UserInput().getWinningNumbers()
    println(Game.BONUS_NUMBER_INPUT.message)
    val bonusNumber = UserInput().getBonusNumber()
    WinningResult().printWinningResult(lottoNumbersList, winningNumbers, bonusNumber, lottoPrice)
}




