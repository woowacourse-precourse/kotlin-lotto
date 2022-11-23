package lotto

import lotto.ui.View
import lotto.domain.LottoShop
import org.junit.jupiter.api.Test

class ViewTest {
    @Test
    fun `구입한 로또 장 수 출력`() {
        val countOfLotto = 14
        View.showCount(countOfLotto)
    }

    @Test
    fun `구입한 로또 번호 출력`() {
        val lottoShop = LottoShop()
        val countOfLotto = 8
        val lottoNumbers = lottoShop.getLottoNumbers(countOfLotto)
        View.showPurchasedLotteries(lottoNumbers)
    }
}