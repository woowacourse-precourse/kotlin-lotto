package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoSellerTest {
    private lateinit var LottoSeller: Seller

    @BeforeEach
    fun setUp() {
        LottoSeller = Seller(LottoGenerator())
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 5000, 8000, 10000])
    fun `check the number of lotto`(receivedMoney: Int) {
        assertThat(LottoSeller.sellLotto(receivedMoney, LOTTO_PRICE).size).isEqualTo(receivedMoney / LOTTO_PRICE)
    }
}