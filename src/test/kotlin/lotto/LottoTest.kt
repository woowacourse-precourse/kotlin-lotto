package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

//도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
//핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
//단위 테스트 작성이 익숙하지 않다면 test/kotlin/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

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

    // 로또 번호에 1~45 범위 초과시 예외가 발생한다.
    // 로또 구매 금액이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.
}
