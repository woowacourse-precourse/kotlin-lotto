package lotto

fun main() {
    val outputView = OutputView()
    val lottoController = LottoController()

    outputView.printStartMessage()

    lottoController.receiveMoney()

    lottoController.createLotto()

    outputView.printWinningNumberMessage()
    lottoController.receiveWinningNumber()

    outputView.printBonusNumberMessage()
    lottoController.receiveBonusNumber()

    lottoController.result()
}
