package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun BonusTest() {
        assertThrows<IllegalArgumentException> {
            Bonus(0)
        }
    }
}