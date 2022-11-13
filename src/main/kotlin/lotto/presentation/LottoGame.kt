package lotto.presentation

import lotto.domain.LottoCheck
import lotto.domain.LottoShop
import lotto.domain.LottoWin
import lotto.presentation.util.Constant.errorMessage
import lotto.presentation.util.Constant.inputAmountMessage
import lotto.presentation.util.Constant.inputBonusMessage
import lotto.presentation.util.Constant.inputWinningMessage
import lotto.presentation.util.inputMoneyException
import lotto.presentation.util.inputTypeException
import java.lang.IllegalArgumentException

class LottoGame {

    fun gameStart() {
        try {
            val userOrder = inputUserLotto()
            val userLottoNumber = LottoShop().buyLotto(userOrder)
            val userInputWinNum = LottoWin().winLotto(inputWinLotto())
            LottoWin().bonusLotto(userInputWinNum, inputBonusLotto())
            val lottoRank = LottoCheck().compareLotto(userLottoNumber)
            LottoBank().yieldLotto(lottoRank, userOrder)

        } catch (e: IllegalArgumentException) {
            println(errorMessage)
        }
    }

    fun inputUserLotto(): Int {
        println(inputAmountMessage)
        val buyAmount = readLine()!!
        buyAmount.inputTypeException()
        return buyAmount.inputMoneyException()

    }

    fun inputWinLotto(): List<String> {
        println(inputWinningMessage)
        return readLine()!!.split(',')
    }

    fun inputBonusLotto(): String {
        println(inputBonusMessage)
        return readLine()!!
    }

}