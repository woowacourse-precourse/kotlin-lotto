package lotto.domain

import lotto.presentation.util.inputLottoNumberTypeException
import lotto.presentation.util.inputWinningBonusNumberException
import lotto.presentation.util.inputWinningNumberException

class LottoWin {

    fun winLotto(userInputLottoNum : List<String>): List<Int> {
        userInputLottoNum.inputLottoNumberTypeException()
        val lottoWinNum = inputWinningNumberException(userInputLottoNum)
        for (i in 0 until LottoWinBall.values().size - 1) {
            LottoWinBall.values()[i].num = lottoWinNum[i]
        }
        return lottoWinNum
    }

    fun bonusLotto(userLottoWinNum: List<Int>, userLottoBonusNum : String) {
        userLottoBonusNum.inputLottoNumberTypeException()
        inputWinningBonusNumberException(userLottoWinNum, userLottoBonusNum.toInt())
        LottoWinBall.BonusBall.num = userLottoBonusNum.toInt()
    }
}