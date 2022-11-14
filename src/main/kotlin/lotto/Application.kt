package lotto

fun main() {
    val game = LottoController()
    val receive = ReceiveSystem()

    try {
        val money = receive.receiveMoney()

        val lottoList = game.createLotto(money)

        val winningNumber = receive.receiveWinningNumber()
        val bonusNumber = receive.receiveBonusNumber(winningNumber)

        val prizeResult = game.concludePrizeResult(lottoList, winningNumber, bonusNumber)

        game.concludeEarningRate(prizeResult[0], money.getMoney().toDouble())
    } catch (e: IllegalArgumentException) {
        return
    }
}
