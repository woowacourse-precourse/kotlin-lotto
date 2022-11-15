package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.assertj.core.api.Assertions.assertThat


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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `발행 로또와 로또 당첨 번호 비교하기`(){
        assertEquals(4,Lotto(listOf(1,13,14,32,35,45)).compare(listOf(1,13,14,32,33,36),4))
    }

    @Test
    fun `보너스 번호가 들어있는지 비교하기`(){
        assertEquals(7,Lotto(listOf(1,13,14,33,34,41)).bonusCoincidence(listOf(1,13,14,33,34,40),40))
    }
}
