package lotto.domain

import lotto.Lotto
import lotto.utils.Constants.LOTTO_PRICE
import lotto.view.OutputView

class Publisher {

    fun generateLottery(money: Money): List<Lotto> {
        val lottoCount = money.purchasingAmount / LOTTO_PRICE
        OutputView.printLottoCount(lottoCount)

        return operateMachine(lottoCount)
    }

    private fun operateMachine(lottoCount: Long): List<Lotto> {
        val lottoTicket = LotteryMachine().operate(lottoCount)
        OutputView.printLottoNumber(lottoTicket)

        return lottoTicket
    }
}
