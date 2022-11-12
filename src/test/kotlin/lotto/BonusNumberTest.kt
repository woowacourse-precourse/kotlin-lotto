package lotto

import lotto.domain.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    private val bonus = BonusNumber(listOf(1, 2, 3, 4, 5, 6), "45")

    @Test
    fun `보너스 당첨 번호가 1~45 사이가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { (bonus.validateRange(46)) }
    }

    @Test
    fun `보너스 당첨 번호가 로또 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (bonus.validateDuplicate(listOf(1, 2, 3, 4, 5, 6), 6)) }
    }

    @Test
    fun `보너스 당첨 번호에 숫자가 아닌 문자가 들어오면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { (bonus.validateType("4a")) }
    }
}