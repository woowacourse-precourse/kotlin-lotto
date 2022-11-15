package view

import util.printLottoEarningsRate
import util.printLottoGradeCountToMessage

class PlayerUI {
    fun <T> showUI(
        ui: UI,
        vararg data: T,
    ) {
        when (ui) {
            UI.ANSWER_EARNING_RATE -> printLottoEarningsRate(
                data[0] as Long,
                data[1] as Int,
            )
            UI.ANSWER_LOTTO_GRADE_RESULT -> printLottoGradeCountToMessage(
                data[0] as Int,
                data[1] as Int,
            )
        }
    }

    companion object {
        enum class UI {
            ANSWER_EARNING_RATE,
            ANSWER_LOTTO_GRADE_RESULT
        }
    }
}