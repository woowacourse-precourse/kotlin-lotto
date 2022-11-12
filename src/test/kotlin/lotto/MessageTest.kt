package lotto

import lotto.domain.Message
import lotto.domain.Service
import org.junit.jupiter.api.Test

class MessageTest {
    @Test
    fun `구입한 로또 장 수 출력`() {
        val countOfLotto = 14
        Message.showCountOfLotto(countOfLotto)
    }

    @Test
    fun `구입한 로또 번호 출력`() {
        val service = Service()
        val countOfLotto = 8
        val lottoNumbers = service.getLottoNumbers(countOfLotto)
        Message.showPurchasedLottoNumbers(lottoNumbers)
    }
}