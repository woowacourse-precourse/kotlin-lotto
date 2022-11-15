package lotto.controller

import lotto.input.InputBonusImpl
import lotto.input.PayedMoneyImpl
import lotto.input.WinningNumberImpl
import lotto.lottoStore.LottoCreateImpl
import lotto.service.CheckContainImpl
import lotto.service.CheckWinningImpl
import lotto.service.YeildImpl


class LottoController {
    private val buyMoney = PayedMoneyImpl().inputUserMoney()
    val Lotto = LottoCreateImpl().LottoCreate(buyMoney)
    val winningNumber = WinningNumberImpl().inputWinningNumber()
    val checkWinningScore = checkWinaLotto(Lotto, InputBonusImpl().inputBonusNumber(winningNumber), winningNumber)

    fun GameStart(){
        YeildImpl().plusMoney(buyMoney, checkWinningScore)
    }

    fun checkWinaLotto(lottoNumber: MutableList<List<Int>>, bonusNumber: Int, winningNumber: String): MutableList<Int> {
        var count: Int
        var lottoWinningAll = mutableListOf(0, 0, 0, 0, 0)
        for (lottonum in lottoNumber) {
            count = CheckContainImpl().containLottoNum(winningNumber, lottonum)
            count = CheckContainImpl().containBonusNum(count, lottonum, bonusNumber)
            lottoWinningAll = CheckWinningImpl().winningCount(count)
        }
        CheckWinningImpl().printresult(lottoWinningAll)
        return lottoWinningAll
    }
}