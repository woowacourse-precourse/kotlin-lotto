package lotto.controller

import lotto.model.*
import lotto.model.Buyer.amount
import lotto.model.Buyer.getBuyCount
import lotto.model.Buyer.lottos
import lotto.model.LottoData.winningLotto
import lotto.model.RewardInfo.add
import lotto.model.RewardInfo.init
import lotto.model.RewardInfo.lottoResult
import lotto.util.Constant.MISS
import lotto.util.Validator.checkBonusInNumber
import lotto.view.InputVIew
import lotto.view.OutputView

class LottoController {
    val outputView = OutputView()
    val inputView = InputVIew()
    fun startLotto() {
        inputMoney()
        generateLotto()
        inputWinningNumber()
        compareLotto()
        printFinalResult()
    }

    fun inputMoney() {
        outputView.requestMoney()
        amount = inputView.inputMoney()
    }

    fun generateLotto() {
        val lottoMaker = LottoMaker()
        val randLottos = lottoMaker.generateLotto(getBuyCount())
        for (lotto in randLottos) {
            lottos.add(Lotto(lotto))
        }
        printLottos(randLottos)
    }

    fun printLottos(lottos: List<List<Int>>) {
        outputView.printLottos(lottos)
    }

    fun inputWinningNumber() {
        outputView.requestWinningNumber()
        val number = inputView.inputWinningNumber()
        outputView.requestBonusNumber()
        val bonus = inputView.inputBonusNumber()
        checkBonusInNumber(bonus, number)
        winningLotto = WinningLotto(number, bonus)
    }

    fun compareLotto() {
        for (lotto in lottos) {
            val matchCount = lotto.countMatchNumber(winningLotto)
            matchReward(matchCount)
        }
    }

    fun matchReward(matchCount: String) {
        val lottoReward = LottoReward()
        val reward = lottoReward.matchReward(matchCount)
        lottoResult.init()
        if (reward != MISS) {
            lottoResult.add(reward as Reward)
        }
    }

    fun printFinalResult() {
        outputView.printResultTitle()
        for (result in lottoResult) {
            when (val reward = result.key) {
                Reward.SECOND -> outputView.printBonusResult(reward, result.value)
                else -> outputView.printResult(reward, result.value)
            }
        }
        printProfit()
    }

    fun printProfit() {
        val lottoReward = LottoReward()
        val profit = lottoReward.calcProfit(amount, lottoResult)
        outputView.printProfit(profit)
    }
}

