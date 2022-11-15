package lotto

import enterprise.LOTTO_NUM_RANGE_END
import enterprise.LOTTO_NUM_RANGE_START
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoFactoryTest {

    private val lottoFactory = LottoFactory()

    @Test
    fun `입력한 갯수만큼 로또 생성`() {
        assert(
            lottoFactory.makeLotties(5).size == 5
        )
    }

    @Test
    fun `로또 생성`() {
        lottoFactory.makeLotties(10).forEach { lotto ->
            for (num in lotto) {
                assertThat(num in LOTTO_NUM_RANGE_START..LOTTO_NUM_RANGE_END)
            }
        }
    }
}