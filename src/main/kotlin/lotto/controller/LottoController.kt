package lotto.controller

import lotto.input.InputBonusImpl
import lotto.input.PayedMoneyImpl
import lotto.input.WinningNumberImpl
import lotto.lottoStore.LottoCreateImpl
import lotto.service.CheckContainImpl
import lotto.service.CheckWinningImpl
import lotto.service.YieldReal


class LottoController {
    private val buyMoney = PayedMoneyImpl().inputUserMoney()
    private val lotto = LottoCreateImpl().createLotto(buyMoney)
    private val winningNumber = WinningNumberImpl().inputWinningNumber()
    private val checkWinningScore = confirmWinning(lotto, InputBonusImpl().inputBonusNumber(winningNumber), winningNumber)

    fun gameStart() {
        YieldReal().plusMoney(buyMoney, checkWinningScore)
    }

    private fun confirmWinning(lottoNumber: MutableList<List<Int>>, bonusNumber: Int, winningNumber: String): MutableList<Int> {
        var count: Int
        var lottoWinningAll = mutableListOf(0, 0, 0, 0, 0)
        for (lottonum in lottoNumber) {
            count = CheckContainImpl().containLottoNum(winningNumber, lottonum)
            count = CheckContainImpl().containBonusNum(count, lottonum, bonusNumber)
            lottoWinningAll = CheckWinningImpl().winningCount(count)
        }
        CheckWinningImpl().printResult(lottoWinningAll)
        return lottoWinningAll
    }
}