package lotto.domain

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RewardTest {
    @Test
    fun `등수 개수 구하기 테스트`(){
        var rewards = mutableListOf<Reward>(Reward.FIFTH, Reward.FIFTH, Reward.THIRD, Reward.FIRST)
        var count = countReward(rewards)
        assertThat(count).containsSequence(1, 0, 1, 0, 2)
    }
}