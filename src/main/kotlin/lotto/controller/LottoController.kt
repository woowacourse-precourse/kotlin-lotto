package lotto.controller

import lotto.model.Buyer
import lotto.model.Lotto
import lotto.model.LottoMaker
import lotto.model.LottoMaker.Companion.allRandomRotto
import lotto.model.LottoMaker.Companion.bonusNumber
import lotto.model.LottoMaker.Companion.winningNumber
import lotto.util.Validator
import lotto.view.Input
import lotto.view.Print

class LottoController {

    fun startLotto() {
        askBuyer()
        generateLotto()
        askWinningLotto()
        showLottoResult()
    }

    fun askBuyer() {
        Buyer.payMoney = Input.buyLotto()
        Buyer.buyCount = Validator.getPurchaseNumber(Buyer.payMoney)
    }

    fun generateLotto() {
        var lottoMaker = LottoMaker()
        println()
        Print.buyLotto(Buyer.buyCount)
        lottoMaker.generateLotto(Buyer.buyCount)
    }

    fun askWinningLotto() {
        winningNumber= Input.winningNumber()
        bonusNumber = Input.bonusNumber()
    }

    fun getLottoReward(lotto: Lotto) {
        var matchingResult = lotto.getMatchingNumber(allRandomRotto)
        lotto.getWinningLotto(matchingResult)
    }

    fun showReturnRate(lotto: Lotto) {
        var returnRate = lotto.calcReturnRate()
        Print.returnRate(returnRate)
    }

    fun showLottoResult() {
        var lotto = Lotto(winningNumber)

        println()
        Print.resultSentence()
        Print.seperator()

        getLottoReward(lotto)
        lotto.produceLottoStats()
        showReturnRate(lotto)
    }
}

