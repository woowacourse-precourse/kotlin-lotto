package lotto.service.dto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `LottoDto 클래스의` {
    @Nested
    inner class `생성자는` {
        @Nested
        inner class `로또가 주어지면` {
            private val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
            @Test
            fun `로또 번호가 오름차순이 되도록 정렬한다`() {
                val lottoDto = LottoDto(lotto)

                assertThat(lottoDto.numbers()).containsExactly(1, 2, 3, 4, 5, 6)
            }
        }
    }
}