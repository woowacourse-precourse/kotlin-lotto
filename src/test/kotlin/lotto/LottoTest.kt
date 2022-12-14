package lotto

import lotto.model.Lotto
import lotto.model.LottoReward
import lotto.model.WinningLotto
import lotto.util.Constant.FIFTH_BONUS
import lotto.util.Constant.MISS
import lotto.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `5개 번호가 일치하면 보너스 번호를 확인한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningLotto = WinningLotto(listOf(1,2,3,4,5,7),6)
        assertEquals(lotto.countMatchNumber(winningLotto), FIFTH_BONUS)
    }

    @ValueSource(strings = ["0", "1", "2"])
    @ParameterizedTest
    fun `당첨 내역이 없으면 MISS를 반환한다`(input: String) {
        val lottoReward = LottoReward()
        assertEquals(lottoReward.matchReward(input), MISS)
    }
}
