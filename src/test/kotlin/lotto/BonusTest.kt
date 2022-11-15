package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {

    @Test
    fun `로또 보너스 번호가 1개 이상 이라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus(12)
        }
    }

}