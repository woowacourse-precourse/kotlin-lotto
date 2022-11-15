package lotto

import org.junit.jupiter.api.Test
import winlotto.WinLotto

class WinLottoTest {
    @Test
    fun `로또 번호의 개수가 7개가 넘어가면 예외가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            WinLotto(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            WinLotto(listOf(1, 2, 3, 4, 5, 6, 1))
        }
    }
}