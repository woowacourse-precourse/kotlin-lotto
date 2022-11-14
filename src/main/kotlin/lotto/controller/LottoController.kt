package lotto.controller

import lotto.domain.model.WinningLottery
import lotto.domain.repository.LottoRepository
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    // TODO 게임플레이를 관리한다.

    private val lottoRepository = LottoRepository()

    fun play() {
        val purchaseMoney = InputView.inputMoney()
        val purchaseLottos = lottoRepository.generateLottos(purchaseMoney)
        OutputView.purchasingLottos(purchaseLottos)
        val winningLottery = WinningLottery(InputView.inputWinningNum(), InputView.inputBonusNum())
        lottoRepository.calStatistics(winningLottery, purchaseLottos)

    }


    companion object {
        const val ERROR_MESSAGE = "[ERROR]"

    }
}