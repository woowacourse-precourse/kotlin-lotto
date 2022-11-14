package lotto.service

import lotto.domain.*
import lotto.presentation.LottoPurchaseView.inputPurchaseAmount
import lotto.presentation.LottoPurchaseView.printPurchaseMessage
import lotto.presentation.LottoPurchaseView.printPurchaseResult
import lotto.presentation.LottoStaticsView.printLottoStatics
import lotto.presentation.WinningLottoView.inputBonusNumber
import lotto.presentation.WinningLottoView.inputWinningLottoNumbers
import lotto.presentation.WinningLottoView.printBonusNumberEnterMessage
import lotto.presentation.WinningLottoView.printWinningLottoEnterMessage
import lotto.utils.INITIAL_COUNT
import lotto.utils.LottoExceptionHandler.validateBonusNumberDuplication

class LottoService : Service() {
    private val lottoStore by lazy { LottoStore() }
    private val lottoRanks = linkedMapOf(
        LottoRank.FIFTH to INITIAL_COUNT,
        LottoRank.FOURTH to INITIAL_COUNT,
        LottoRank.THIRD to INITIAL_COUNT,
        LottoRank.SECOND to INITIAL_COUNT,
        LottoRank.FIRST to INITIAL_COUNT,
    )

    override fun start() {
        val amount = inputAmount()
        val lottos = purchaseLottos(amount)
        val (winningLotto, bonusNumber) = inputWinningLotto()
        val rewardMoney = calculateTotalReward(lottos, winningLotto, bonusNumber)
        val lottoRanks = LottoRanks(lottoRanks)

        printLottoStatics(lottoRanks, rewardMoney, amount)
    }

    private fun inputAmount(): Money {
        printPurchaseMessage()
        return inputPurchaseAmount()
    }

    private fun purchaseLottos(amount: Money): List<Lotto> {
        val lottos = lottoStore.purchase(amount)
        printPurchaseResult(lottos)

        return lottos
    }

    private fun inputWinningLotto(): Pair<WinningLotto, LottoNumber> {
        printWinningLottoEnterMessage()
        val winningLotto = inputWinningLottoNumbers()

        printBonusNumberEnterMessage()
        val bonusNumber = inputBonusNumber()

        validateBonusNumberDuplication(winningLotto, bonusNumber)
        return Pair(winningLotto, bonusNumber)
    }

    private fun calculateTotalReward(lottos: List<Lotto>, winningLotto: WinningLotto, bonusNumber: LottoNumber): Money {
        var rewardMoney = 0
        lottos.forEach { lotto ->
            val winningRank = winningLotto.compareLottoRank(lotto, bonusNumber)
            val originWinningCount = lottoRanks.getOrElse(winningRank) {
                return@forEach
            }

            lottoRanks[winningRank] = originWinningCount + 1
            rewardMoney += winningRank.reward
        }
        return Money(rewardMoney)
    }
}