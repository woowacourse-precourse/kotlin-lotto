package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BroadcastTest {

    @BeforeEach
    fun setUp(){
        var winningNumbers = listOf(1,2,3,4,5,6)
    }

    @Test
    fun `로또 2등 테스트(5개맞추고 보너스)`() {

        assertThat(Broadcast().bonusWinningNumber(mutableListOf(
            listOf(1,2,3,4,5,6),
            listOf(1,2,3,4,5,7),
            listOf(1,2,3,4,5,8),
            listOf(1,2,3,4,5,9),),7)).isEqualTo(1)

    }
}