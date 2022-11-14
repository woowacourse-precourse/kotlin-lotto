package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
    @Test
    fun `로또 번호의 개수가 6개가 안되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }
    @Test
    fun `로또 번호 입력에 콤마를 넣지 않으면 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(123456))
        }
    }
    @Test
    fun `1부터 45에 포함되는 숫자가 입력으로 안 온 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2,3,5,70,-1))
        }
    }
}
