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
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }   
    @Test
    fun `로또 번호에 문자열이 포함된 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, a, 5))
        }
    }
    @Test
    fun `로또 번호에 '0'이 포함된 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 0, 5))
        }
    }
    @Test
    fun `로또 번호에 공백이 포함된 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, , 5))
        }
    }
    @Test
    fun `로또 번호에 구분자 ","를 사용하지 않은 경우`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3 4''5))
        }
    }
}
