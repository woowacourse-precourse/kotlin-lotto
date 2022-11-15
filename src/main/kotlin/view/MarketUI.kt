package view

import util.printAnswerBuyLottoCount
import util.printAskPayMoneyInput

class MarketUI {
    fun <T> showUI(
        ui: UI,
        data: T?,
    ) {
        when (ui) {
            UI.ASK_PAY_MONEY_INPUT -> printAskPayMoneyInput()
            UI.ANSWER_BUY_LOTTO_COUNT -> printAnswerBuyLottoCount(data as Int)
            UI.ANSWER_LOTTO -> println(data as List<*>)
        }
    }

    companion object {
        enum class UI {
            ASK_PAY_MONEY_INPUT,
            ANSWER_BUY_LOTTO_COUNT,
            ANSWER_LOTTO
        }
    }
}