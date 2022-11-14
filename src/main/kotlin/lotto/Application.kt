package lotto

import lotto.domain.Lotto
import lotto.domain.View.showResultOfLotto
import lotto.domain.ApplicationService
import lotto.domain.DomainService

fun main() {
    playLotto()
}

fun playLotto() {
    val applicationService = ApplicationService()
    val domainService = DomainService()
    val countOfLotto = retryGetPurchasingAmount(applicationService)
    val lottoNumbers = applicationService.getLottoNumbers(countOfLotto)
    val winningNumbers = retryGetWinningNumbers(applicationService)
    val bonusNumber = retryGetBonusNumber(applicationService, winningNumbers)
    val resultOfLotto = domainService.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
    showResultOfLotto(resultOfLotto, countOfLotto)
}

fun retryGetPurchasingAmount(applicationService: ApplicationService): Int {
    var countOfLotto: Int
    do {
        countOfLotto = applicationService.getPurchasingAmount()
    } while (countOfLotto == 0)
    return countOfLotto
}

fun retryGetWinningNumbers(applicationService: ApplicationService): Lotto {
    var winningNumbers: Lotto?
    do {
        winningNumbers = applicationService.getWinningNumbers()
    } while (winningNumbers == null)
    return winningNumbers
}

fun retryGetBonusNumber(applicationService: ApplicationService, winningNumbers: Lotto): Int {
    var bonusNumber: Int
    do {
        bonusNumber = applicationService.getBonusNumber(winningNumbers)
    } while (bonusNumber == 0)
    return bonusNumber
}
