package lotto

import lotto.domain.ApplicationService
import lotto.domain.DomainService
import lotto.domain.View.showResultOfLotto

fun main() {
    playLotto()
}

fun playLotto() {
    val applicationService = ApplicationService()
    val domainService = DomainService()

    val countOfLotto = applicationService.retryGetPurchasingAmount(applicationService)
    val lottoNumbers = applicationService.getLottoNumbers(countOfLotto)
    val winningNumbers = applicationService.retryGetWinningNumbers(applicationService)
    val bonusNumber = applicationService.retryGetBonusNumber(applicationService, winningNumbers)
    val resultOfLotto = domainService.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
    showResultOfLotto(resultOfLotto, countOfLotto)
}






