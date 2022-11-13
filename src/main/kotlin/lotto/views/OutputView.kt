package lotto.views

import lotto.constants.Constant
import lotto.constants.Message
import lotto.domain.Lotto
import lotto.domain.LottoWrapper

object OutputView {
    fun printInputMoney() {
        println(Message.MESSAGE_INPUT_MONEY)
    }

    fun printAmount(amount: Int) {
        println("$amount" + Message.MESSAGE_PRINT_AMOUNT)
    }

    fun printLottos(lottos: LottoWrapper) {
        for (index in Constant.START_INDEX until lottos.size()) {
            val lotto = lottos.get(index)
            println(lotto.getNumbers())
        }
    }
}