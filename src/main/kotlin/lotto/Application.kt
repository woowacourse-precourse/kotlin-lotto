package lotto

import lotto.domain.Messages.showCountOfLotto
import lotto.domain.Messages.showInputBonusNumber
import lotto.domain.Messages.showInputPurchasingAmount
import lotto.domain.Messages.showInputWinningNumber
import lotto.domain.Messages.showPurchasedLottoNumbers
import lotto.domain.Messages.showResultOfLotto
import lotto.domain.Service

fun main() {
    playLotto()
}

fun playLotto() {
    try {
        val service = Service()
        showInputPurchasingAmount()
        val countOfLotto = service.getPurchasingAmount()
        showCountOfLotto(countOfLotto)
        val lottoNumbers = service.getLottoNumbers(countOfLotto)
        showPurchasedLottoNumbers(lottoNumbers)
        showInputWinningNumber()
        val winningNumbers = service.getWinningNumbers()
        showInputBonusNumber()
        val bonusNumber = service.getBonusNumber(winningNumbers)
        val resultOfLotto = service.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
        showResultOfLotto(resultOfLotto, countOfLotto)
    } catch (e: IllegalArgumentException) {
        println("[ERROR]")
    }
}


