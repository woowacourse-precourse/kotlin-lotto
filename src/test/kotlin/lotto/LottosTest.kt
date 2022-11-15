package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    val user = listOf(
    Lotto(listOf(1,2,3,4,5,6)),
    Lotto(listOf(1,5,12,22,32,41)),
    Lotto(listOf(1,3,5,14,22,33)),
    Lotto(listOf(1,5,14,22,33,41))
    )

    val userLottos = Lottos(user)

    @Test
    fun `lottos 당첨 결과 확인`() {

        val answer = Lotto(listOf(1, 5, 14, 22, 33, 41))
        val bonus = 3

        assertThat(userLottos.matchLotto(answer, bonus).first).isEqualTo(1)
        assertThat(userLottos.matchLotto(answer, bonus).second).isEqualTo(1)
        assertThat(userLottos.matchLotto(answer, bonus).third).isEqualTo(0)
        assertThat(userLottos.matchLotto(answer, bonus).fourth).isEqualTo(1)
        assertThat(userLottos.matchLotto(answer, bonus).fifth).isEqualTo(0)
    }

}