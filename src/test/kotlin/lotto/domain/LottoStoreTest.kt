package lotto.domain

import lotto.utils.LOTTO_PRICE
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LottoStoreTest {

    lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore()
    }

    @Test
    fun `입력받은 금액만큼 로또를 발행한다`() {
        val amount = 5000
        val lottos = lottoStore.purchase(Money(amount))

        assertTrue(lottos.size == amount / LOTTO_PRICE)
    }
}