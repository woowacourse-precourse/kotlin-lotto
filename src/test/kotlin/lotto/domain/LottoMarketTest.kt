package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMarketTest {
    private lateinit var lottoMarket: LottoMarket

    @BeforeEach
    fun setUp() {
        lottoMarket = LottoMarket()
    }

    @Test
    fun `로또 발행이 원하는 수만큼 발행되는지 확인`() {
        val theNumberOfLotto = 2L
        val answer = 2
        assertThat(lottoMarket.buyLottos(theNumberOfLotto).size).isEqualTo(answer)
    }

    @Test
    fun `로또의 수가 6개가 발행되는지 확인`() {
        assertThat(lottoMarket.createLotto().size).isEqualTo(6)
    }

    @Test
    fun `발행된 로또가 알맞은 범위내의 수로 이루어져있는지 확인`() {
        val lotto = lottoMarket.createLotto()
        var isCorrect = true
        for (number in lotto) {
            if (number !in 1..45) {
                isCorrect = false
            }
        }
        assertThat(isCorrect).isEqualTo(true)
    }

    @Test
    fun `구입금액에 따른 로또 개수가 알맞게 반환되는지 확인`() {
        val purchasingAmount = 10000L
        val answer = 10L
        val theNumberOfLotto = lottoMarket.getTheNumberOfLotto(purchasingAmount)
        assertThat(theNumberOfLotto).isEqualTo(answer)
    }


}