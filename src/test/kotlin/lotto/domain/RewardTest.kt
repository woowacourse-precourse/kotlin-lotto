package lotto.domain

import lotto.views.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RewardTest {
    @Test
    fun `등수 개수 구하기 테스트`() {
        var rewards = mutableListOf<Reward>(Reward.FIFTH, Reward.FIFTH, Reward.THIRD, Reward.FIRST)
        var count = countReward(rewards)
        assertThat(count).containsSequence(1, 0, 1, 0, 2)
    }

    @Test
    fun `수익률 출력 테스트`() {
        var rewards = mutableListOf<Reward>(Reward.FIFTH)
        var result = calculateYield(rewards, 8)
        OutputView.printYield(result)
    }
}