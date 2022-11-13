package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoSellerTest {
    private lateinit var Seller: LottoSeller

    @BeforeEach
    fun setUp() {
        Seller = Seller(LottoGenerator())
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 5000, 8000, 10000])
    fun `check the number of lotto`(receivedMoney: Int) {
        assertThat(Seller.sellLotto(receivedMoney).size).isEqualTo(receivedMoney / LOTTO_PRICE)
    }
}