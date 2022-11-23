package lotto.controller

import lotto.domain.LottoShop
import lotto.domain.LottoService
import lotto.ui.View

class LottoGameController {
    private val lottoShop = LottoShop()
    private val lottoService = LottoService()
    private val view = View

    fun play() {
        val lottoCount = lottoShop.retryGetPurchasingAmount(lottoShop)
        val lotteries = lottoShop.getLottoNumbers(lottoCount)
        val winningNumbers = lottoShop.retryGetWinningNumbers(lottoShop)
        val bonusNumber = lottoShop.retryGetBonusNumber(lottoShop, winningNumbers)
        val resultOfLotto = lottoService.isWinningLotto(lotteries, winningNumbers, bonusNumber)
        view.showResult(resultOfLotto, lottoCount)
    }
}