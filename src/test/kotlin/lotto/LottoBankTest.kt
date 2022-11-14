package lotto

import lotto.presentation.LottoBank
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoBankTest {

    @Test
    fun `구매한 로또 번호가 1등 복권인 경우`() {
        val lottoBank: LottoBank = LottoBank()
        val lottoYield = lottoBank.yieldLotto(listOf(0, 0, 0, 0, 1), 5000)
        Assertions.assertThat(lottoYield)
    }
}