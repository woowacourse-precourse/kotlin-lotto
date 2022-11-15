package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShopTest {

    @Test
    fun `가격에 따라 산 로또 개수`() {
        val shop = Shop()
        val price = 8000
        val myLotto = shop.buyLotto(price)
        val result = myLotto.size
        assertThat(result).isEqualTo(8)
    }
}