package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoList
import lotto.enum.Configuration
import lotto.ui.UIManager

class LottoGameController(private val uiManager: UIManager) {
    fun play() {
        try {
            val purchaseAmount = uiManager.askPurchaseAmount()
            uiManager.printPurchaseNumber(purchaseAmount / Configuration.LOTTO_PRICE.number)

            val userLotto = getUserLotto(purchaseAmount)
            uiManager.printUserLotto(userLotto)

            val (winningLotto, bonusNumber) = uiManager.askDrawnNumbers()
            val lottoGame = LottoGame(winningLotto, bonusNumber, userLotto)
            val gameResult = lottoGame.play()
            uiManager.printWinningStatistics(winningList = gameResult.first, earningsRate = gameResult.second)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
        }
    }

    private fun getUserLotto(purchaseAmount: Int): LottoList {
        val result = mutableListOf<Lotto>()
        for (i in 0 until purchaseAmount / Configuration.LOTTO_PRICE.number) {
            result.add(generateLotto())
        }
        return LottoList(result)
    }

    private fun generateLotto(): Lotto {
        val uniqueNumbers = Randoms.pickUniqueNumbersInRange(
            Configuration.START_LOTTO_NUMBER.number,
            Configuration.END_LOTTO_NUMBER.number,
            Configuration.LOTTO_SIZE.number
        )
        return Lotto(uniqueNumbers)
    }
}