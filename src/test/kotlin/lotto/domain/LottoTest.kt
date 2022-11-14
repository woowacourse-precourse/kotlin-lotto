package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `정상적인 로또 범위는 잘 생성된다`() {
        assertThat(
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
    }

    @Test
    fun `로또 범위 이외의 숫자가 들어오면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, -1))
        }
    }

    @Test
    fun `로또 저장 후 매개변수를 잘 받을 수 있다`() {
        assertThat(
            Lotto(listOf(1, 2, 3, 4, 5, 6)).toList() == listOf(1, 2, 3, 4, 5, 6)
        )
    }
}
