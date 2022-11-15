package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `당첨 번호와 중복되는 보너스 번호`() {
        assertThrows<IllegalArgumentException> {
            Bonus("6", listOf(1, 2, 3, 4, 5, 6))
        }
    }
    @Test
    fun `1~45 범위 외의 보너스 번호(1)`() {
        assertThrows<IllegalArgumentException> {
            Bonus("55", listOf(1, 2, 3, 4, 5, 6))
        }
    }
    @Test
    fun `1~45 범위 외의 보너스 번호(2)`() {
        assertThrows<IllegalArgumentException> {
            Bonus("0", listOf(1, 2, 3, 4, 5, 6))
        }
    }
}