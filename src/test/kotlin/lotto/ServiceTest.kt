package lotto

import lotto.domain.Lotto
import lotto.domain.Message
import lotto.domain.Service
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ServiceTest {

    @Test
    fun `당첨 여부 확인 테스트`() {
        val service = Service()
        val countOfLotto = 8
        val lottoNumbers = service.getLottoNumbers(countOfLotto)
        Message.showPurchasedLottoNumbers(lottoNumbers)
        val winningNumbers = Lotto(listOf(4,3,7,9,12,36))
        val bonusNumber = 45
        val winningLotto = service.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
        println(winningLotto.toString())
    }
}