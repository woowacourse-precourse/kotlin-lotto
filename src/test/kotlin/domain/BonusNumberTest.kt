package domain

import domain.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `보너스 번호에 1~45 이외 값이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(46,listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `보너스 번호가 입력한 6개의 로또 번호와 중복된다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber(6,listOf(1,2,3,4,5,6))
        }
    }
}