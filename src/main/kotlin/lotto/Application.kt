package lotto

import lotto.domain.Message.showCountOfLotto
import lotto.domain.Message.showInputBonusNumber
import lotto.domain.Message.showInputPurchasingAmount
import lotto.domain.Message.showInputWinningNumber
import lotto.domain.Message.showPurchasedLottoNumbers
import lotto.domain.Service

fun main() {
    TODO("프로그램 구현")
    playLotto()
}

fun playLotto() {
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
}


