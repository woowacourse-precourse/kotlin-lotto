package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest : NsTest() {

    @Test
    fun `일치하는 숫자 개수를 받아 당첨 여부를 결정한다`() {
        assertThat(Prize.NOTHING.updatePrize(6, true)).isEqualTo(Prize.FIRST)
        assertThat(Prize.NOTHING.updatePrize(5, true)).isEqualTo(Prize.SECOND)
        assertThat(Prize.NOTHING.updatePrize(5, false)).isEqualTo(Prize.THIRD)
        assertThat(Prize.NOTHING.updatePrize(4, true)).isEqualTo(Prize.FOURTH)
        assertThat(Prize.NOTHING.updatePrize(3, true)).isEqualTo(Prize.FIFTH)
        assertThat(Prize.NOTHING.updatePrize(1, true)).isEqualTo(Prize.NOTHING)
    }

    @Test
    fun `당첨 등수에 맞게 상금을 결정한다`() {
        assertThat(Prize.FIRST.earnings).isEqualTo(2_000_000_000)
        assertThat(Prize.SECOND.earnings).isEqualTo(30_000_000)
        assertThat(Prize.THIRD.earnings).isEqualTo(1_500_000)
        assertThat(Prize.FOURTH.earnings).isEqualTo(50_000)
        assertThat(Prize.FIFTH.earnings).isEqualTo(5_000)
        assertThat(Prize.NOTHING.earnings).isEqualTo(0)
    }

    override fun runMain() {
        main()
    }
}