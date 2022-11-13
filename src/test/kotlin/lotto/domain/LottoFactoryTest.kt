package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `LottoFactory 클래스의` {
    @Nested
    inner class `createRandomLotto 메소드는` {
        @Nested
        inner class `실행하면` {
            @Test
            fun `1에서 45 사이의 서로 다른 숫자 6개의 번호를 가진 로또를 생성한다`() {
                repeat(1000) {
                    val lotto = LottoFactory.createRandomLotto()

                    assertThat(lotto.numbers()).hasSize(6)
                    assertThat(lotto.numbers()).allMatch { number -> number in 1..45 }
                    assertThat(lotto.numbers()).hasSize(lotto.numbers().toSet().size)
                }
            }
        }
    }

}