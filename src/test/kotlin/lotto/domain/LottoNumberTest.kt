package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @DisplayName("로또 숫자가 0인 경우")
    @Test
    fun `로또 번호가 0이면 예외 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @DisplayName("로또 숫자가 46인 경우")
    @Test
    fun `로또 번호가 46이면 예외 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }

    @DisplayName("로또 숫자가 범위에 속하는 경우")
    @Test
    fun `로또 번호가 범위에 속하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            LottoNumber(45)
        }
    }
}