package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoCountTest {

    @Test
    fun `금액에 따른 로또 개수 계산`() {
        Assertions.assertThat(LottoCount().printLottoConut(8000)).isEqualTo(8)
    }
}