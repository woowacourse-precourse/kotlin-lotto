package lotto

import lotto.domain.Lotto
import lotto.domain.Messages.showResultOfLotto
import lotto.domain.Service

fun main() {
    playLotto()
}

fun playLotto() {
    val service = Service()
    val countOfLotto = retryGetPurchasingAmount(service)
    val lottoNumbers = service.getLottoNumbers(countOfLotto)
    val winningNumbers = retryGetWinningNumbers(service)
    val bonusNumber = retryGetBonusNumber(service, winningNumbers)
    val resultOfLotto = service.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
    showResultOfLotto(resultOfLotto, countOfLotto)
}

fun retryGetPurchasingAmount(service: Service): Int {
    var countOfLotto: Int
    do {
        countOfLotto = service.getPurchasingAmount()
    } while (countOfLotto == 0)
    return countOfLotto
}

fun retryGetWinningNumbers(service: Service): Lotto {
    var winningNumbers: Lotto?
    do {
        winningNumbers = service.getWinningNumbers()
    } while (winningNumbers == null)
    return winningNumbers
}

fun retryGetBonusNumber(service: Service, winningNumbers: Lotto): Int {
    var bonusNumber: Int
    do {
        bonusNumber = service.getBonusNumber(winningNumbers)
    } while (bonusNumber == 0)
    return bonusNumber
}
