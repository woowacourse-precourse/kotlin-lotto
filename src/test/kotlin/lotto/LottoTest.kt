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
    fun `로또 번호에 1~45에 해당하는 숫자가 아닌 다른 값이 배정되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 47))
        }
    }
    @Test
    fun `로또 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoWinNums(listOf(1, 2, 3, 4, 5, 5),7)
        }
    }
    @Test
    fun `로또 당첨 번호와 보너스 숫자가 중복이면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoWinNums(listOf(1, 2, 3, 4, 5, 6),6)
        }
    }
    @Test
    fun `로또 당첨 번호와 보너스 숫자가 1~45에 해당하는 숫자가 아닌 다른 값이 배정되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoWinNums(listOf(1, 2, 3, 4, 5, 47),1)
        }
        assertThrows<IllegalArgumentException> {
            LottoWinNums(listOf(1, 2, 3, 4, 5, 45),47)
        }
    }

}
