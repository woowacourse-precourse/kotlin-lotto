package lotto.controller

import lotto.input.InputBonus
import lotto.input.PayedMoney
import lotto.input.WinningNumber
import lotto.lottoStore.LottoCreate
import lotto.service.CheckContain
import lotto.service.CheckWinning
import lotto.service.Yeild
import lotto.util.input

class lottoController(){
    private val buyMoney = PayedMoney().inputUserMoney()
    val Lotto = LottoCreate().createLotto(buyMoney)
    val winningNumber = WinningNumber().inputWinningNumber()
    val checkWinningScore = checkWinaLotto(Lotto, InputBonus(winningNumber).inputBonusNumber(), winningNumber)

    fun GameStart(){
        Yeild().plusMoney(buyMoney, checkWinningScore)
    }

    fun checkWinaLotto(lottoNumber: MutableList<List<Int>>, bonusNumber: Int, winningNumber: String): MutableList<Int> {
        var count: Int
        var lottoWinningAll = mutableListOf(0, 0, 0, 0, 0)
        for (lottonum in lottoNumber) {
            count = CheckContain().containLottoNum(winningNumber, lottonum)
            count = CheckContain().containBonusNum(count, lottonum, bonusNumber)
            lottoWinningAll = CheckWinning().winningCount(count)
        }
        CheckWinning().printresult(lottoWinningAll)
        return lottoWinningAll
    }
}