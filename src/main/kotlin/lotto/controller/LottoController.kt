package lotto.controller

import lotto.model.Buyer.lottoCount
import lotto.model.Buyer.lottos
import lotto.model.LottoData.bonusNumber
import lotto.model.LottoData.winningNumber
import lotto.model.LottoMaker
import lotto.view.InputVIew
import lotto.view.OutputView

class LottoController {
    val outputView = OutputView()
    val inputView = InputVIew()
    fun startLotto() {
        inputMoney()
        inputWinningNumber()
    }

    fun inputMoney(){
        outputView.requestMoney()
        val money = inputView.inputMoney()
        lottoCount = money
        generateLotto()
    }

    fun generateLotto() {
        val lottoMaker = LottoMaker()
        val randLottos = lottoMaker.generateLotto()
        lottos = randLottos
        printLottos(lottos)
    }

    fun printLottos(lottos: List<List<Int>>) {
        outputView.printLottos(lottoCount, lottos)
    }

    fun inputWinningNumber() {
        outputView.requestWinningNumber()
        winningNumber = inputView.inputWinningNumber()
        outputView.requestBonusNumber()
        bonusNumber = inputView.inputBonusNumber()
    }

/*    fun startLotto() {
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
    }*/
}

