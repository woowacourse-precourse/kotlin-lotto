package lotto

import lotto.utils.ErrorCheck
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
    fun `로또 번호 범위를 초과한 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck().ListnumberRange(listOf(51, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 번호가 로또 번호와 중복되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            ErrorCheck().isNotIncludedNumbers(3, listOf(1, 2, 3, 4, 5, 5))
        }
    }
}
