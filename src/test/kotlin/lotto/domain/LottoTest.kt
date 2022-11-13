package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { number -> LottoNumber(number) })
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `로또 번호의 개수가 6개이고 중복되지 않으면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `로또 번호 출력시 대괄호로 감싸고 콤마로 구분된 문자열을 출력한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) })
        assertEquals(
            lotto.toString(),
            "[1, 2, 3, 4, 5, 6]"
        )
    }
}
