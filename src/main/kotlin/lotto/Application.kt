package lotto


fun main() {
    val game = LottoController()
    try {
        game.receiveMoney()
        game.createLotto()
        game.receiveWinningNumber()
        game.receiveBonusNumber()
        game.concludePrizeResult()
        game.concludeEarningRate()

    } catch (e: IllegalArgumentException) {
        return
    }
}
