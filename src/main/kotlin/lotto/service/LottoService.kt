package lotto.service

import lotto.domain.*
import lotto.presentation.LottoConsole
import lotto.presentation.LottoConsole.printLottoStatics
import lotto.utils.INITIAL_COUNT

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

    private fun inputAmount(): Money = lottoStore.inputAmount()

    private fun purchaseLottos(amount: Money): List<Lotto> = lottoStore.purchase(amount)

    private fun inputWinningLotto(): Pair<WinningLotto, LottoNumber> {
        LottoConsole.printWinningLottoEnterMessage()
        val winningLotto = LottoConsole.inputWinningLottoNumbers()

        LottoConsole.printBonusNumberEnterMessage()
        val bonusNumber = LottoConsole.inputBonusNumber()
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