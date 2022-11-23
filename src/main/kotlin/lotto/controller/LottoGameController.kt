package lotto.controller

import lotto.domain.ApplicationService
import lotto.domain.DomainService
import lotto.domain.View

class LottoGameController {
    private val applicationService = ApplicationService()
    private val domainService = DomainService()

    fun play() {
        val countOfLotto = applicationService.retryGetPurchasingAmount(applicationService)
        val lottoNumbers = applicationService.getLottoNumbers(countOfLotto)
        val winningNumbers = applicationService.retryGetWinningNumbers(applicationService)
        val bonusNumber = applicationService.retryGetBonusNumber(applicationService, winningNumbers)
        val resultOfLotto = domainService.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
        View.showResultOfLotto(resultOfLotto, countOfLotto)
    }
}