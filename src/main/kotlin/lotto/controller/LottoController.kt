package lotto.controller

import lotto.input.InputBonusReal
import lotto.input.PayedMoneyReal
import lotto.input.WinningNumberReal
import lotto.lottostore.LottoCreateReal
import lotto.service.CheckContainReal
import lotto.service.CheckWinningReal
import lotto.service.YieldReal


class LottoController {
    private val buyMoney = PayedMoneyReal().inputUserMoney()
    private val lotto = LottoCreateReal().createLotto(buyMoney)
    private val winningNumber = WinningNumberReal().inputWinningNumber()
    private val checkWinningScore = confirmWinning(lotto, InputBonusReal().inputBonusNumber(winningNumber), winningNumber)

    fun gameStart() {
        YieldReal().plusMoney(buyMoney, checkWinningScore)
    }

    private fun confirmWinning(lottoNumber: MutableList<List<Int>>, bonusNumber: Int, winningNumber: String): MutableList<Int> {
        var count: Int
        var lottoWinningAll = mutableListOf(0, 0, 0, 0, 0)
        for (lottonum in lottoNumber) {
            count = CheckContainReal().containLottoNum(winningNumber, lottonum)
            count = CheckContainReal().containBonusNum(count, lottonum, bonusNumber)
            lottoWinningAll = CheckWinningReal().winningCount(count)
        }
        CheckWinningReal().printResult(lottoWinningAll)
        return lottoWinningAll
    }
}