package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoCheckTest {

    @Test
    fun `로또 번호가 당첨 번호와 6개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(6, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.FIRST)
    }

    @Test
    fun `로또 번호가 당첨 번호와 5개와 보너스 번호가 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(5, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.SECOND)
    }

    @Test
    fun `로또 번호가 당첨 번호와 5개 일치하고 보너스 번호가 일치하지 않는다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(5, false)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.THIRD)
    }

    @Test
    fun `로또 번호가 당첨 번호와 4개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(4, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.FOURTH)
    }

    @Test
    fun `로또 번호가 당첨 번호와 3개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(3, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.FIFTH)
    }

    @Test
    fun `로또 번호가 당첨 번호와 2개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(2, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.NOTHING)
    }

    @Test
    fun `로또 번호가 당첨 번호와 1개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(1, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.NOTHING)
    }

    @Test
    fun `로또 번호가 당첨 번호와 0개 일치한다`() {
        val lottoCheck: LottoCheck = LottoCheck()
        val lottoReward = lottoCheck.rankLotto(0, true)
        Assertions.assertThat(lottoReward).isEqualTo(LottoCheck.LottoReward.NOTHING)
    }
}