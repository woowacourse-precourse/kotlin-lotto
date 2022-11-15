package lotto.domain

import lotto.domain.Lotto
import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `입력 받은 로또 당첨 번호가 7개 이상인 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6, 7), 8)
        }
    }

    @Test
    fun `입력 받은 로또 당첨 번호가 5개 이하인 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5), 8)
        }
    }

    @Test
    fun `입력 받은 로또 당첨 번호에 중복이 존재하는 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 4, 5), 8)
        }
    }

    @Test
    fun `입력받은 로또 당첨 번호가 0 이하의 숫자가 존재하는 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(0, 2, 3, 4, 5, 6), 8)
        }
    }

    @Test
    fun `입력받은 로또 당첨 번호가 46이상의 숫자가 존재하는 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 46, 5, 6), 8)
        }
    }

    @Test
    fun `보너스 숫자가 중복인 경우 테스트`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6), 4)
        }
    }

    @Test
    fun `보너스 숫자가 1~45 범위 안의 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }
}