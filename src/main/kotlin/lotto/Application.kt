package lotto

import lotto.controller.LottoGameController
import lotto.domain.ApplicationService
import lotto.domain.DomainService
import lotto.domain.View.showResultOfLotto

fun main() {
    val lottoGameController = LottoGameController()
    lottoGameController.play()
}







