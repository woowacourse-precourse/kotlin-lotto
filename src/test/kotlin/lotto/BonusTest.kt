package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    fun `보너스가 0일때`(){
        val number : List<Int> = listOf(2,3,4,5,6,8)
        assertThrows<IllegalArgumentException> {
            Bonus(number,0)
        }
    }

    @Test
    fun `보너스가 로또번호와 같을 때` () {
        val number : List<Int> = listOf(2,3,4,5,6,8)
        assertThrows<IllegalArgumentException> {
            Bonus(number,2)
        }
    }
}