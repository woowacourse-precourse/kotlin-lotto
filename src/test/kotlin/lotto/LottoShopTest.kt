package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {

    @Test
    fun `로또를 구입 금액에 해당하는 만큼 살 수 있다`() {
        val lottoShop: LottoShop = LottoShop()
        val cntLotto = lottoShop.cntLotto(8000)
        Assertions.assertThat(cntLotto).isEqualTo(8)
    }

    @Test
    fun `로또를 구입 금액이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {

    }
}
