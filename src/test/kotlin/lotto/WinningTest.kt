package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningTest {
    private val win = Winning("1,2,3,4,5,6")

    @Test
    fun `로또 당첨 번호에 중복된 수가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (win.validateLuckyNumberDuplicate(listOf(1, 2, 3, 4, 5, 5))) }
    }

    @Test
    fun `로또 당첨 번호가 1~45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (win.validateLuckyNumberRange(listOf(1, 2, 3, 4, 5, 46))) }
    }

    @Test
    fun `로또 당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (win.splitLuckyNumber("1,2,3,4,5")) }
    }

    @Test
    fun `보너스 당첨 번호가 1~45 사이가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { (win.validateBonusNumberRange(46)) }
    }

    @Test
    fun `보너스 당첨 번호가 로또 당첨 번호와 중복되면 예외가 발생한다`() {
        win.splitLuckyNumber("1,2,3,4,5,6")
        assertThrows<IllegalArgumentException> { (win.compareBonusWithLuckyNumber(4)) }
    }


}