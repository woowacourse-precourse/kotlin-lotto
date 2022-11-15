package lotto

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

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `전체 로또 당첨 개수를 확인한다`() {
        winnings = listOf("5", "8", "9", "10", "11", "12")
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).calculateLottoWin(
            2, arrayOf(intArrayOf(1, 2, 3, 5, 8, 9), intArrayOf(2, 3, 4, 5, 10, 11)), 40
        ))
            .isEqualTo(mutableListOf<Int>(0, 0, 0, 2, 0, 0, 0, 0))
    }

    @Test
    fun `로또 번호가 당첨 번호 중에 있는지 확인한다`() {
        winnings = listOf("5", "8", "9", "10", "11", "12")
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).compareWithLottoNum(
            5, 7, 0)
        )
            .isEqualTo(listOf(1, 0))
    }
    
}
