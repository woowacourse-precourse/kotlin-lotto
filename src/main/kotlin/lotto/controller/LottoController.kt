package lotto.controller

import lotto.domain.LottoGame
import lotto.domain.model.Lotto
import lotto.domain.model.Lotto.Companion.LOTTO_PRIZE
import lotto.domain.repository.LottoRepository
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    // TODO 게임플레이를 관리한다.

    private val lottoRepository = LottoRepository()

    fun play() {

    }


    companion object {
        const val ERROR_MESSAGE = "[ERROR]"

    }
}