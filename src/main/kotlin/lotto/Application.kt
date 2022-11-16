package lotto

import lotto.controller.LottoGameController
import lotto.ui.*

fun main() {
    val inputValidator = InputValidator()
    val inputManager = InputManager(inputValidator)
    val outputManager = OutputManager()
    val uiManager = UIManager(inputManager, outputManager)
    val lottoGameController = LottoGameController(uiManager)
    lottoGameController.play()
}
