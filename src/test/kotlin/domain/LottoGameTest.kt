package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `로또 개수만큼 적절하게 로또가 생성되는지 테스트`() {
        val num = 3
        assertThat(getLottoNumbers(num).size).isEqualTo(num)
    }
}