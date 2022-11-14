package lotto

import lotto.domain.View
import lotto.domain.ApplicationService
import org.junit.jupiter.api.Test

class ViewTest {
    @Test
    fun `구입한 로또 장 수 출력`() {
        val countOfLotto = 14
        View.showCountOfLotto(countOfLotto)
    }

    @Test
    fun `구입한 로또 번호 출력`() {
        val applicationService = ApplicationService()
        val countOfLotto = 8
        val lottoNumbers = applicationService.getLottoNumbers(countOfLotto)
        View.showPurchasedLottoNumbers(lottoNumbers)
    }
}