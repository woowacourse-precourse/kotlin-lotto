package lotto

import lotto.domain.LottoStaff
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class LottoStaffTest {
    private lateinit var lottoStaff: LottoStaff

    @BeforeEach
    fun setUp() {
        lottoStaff = LottoStaff()
    }

    @Test
    fun `구매 금액에 따른 로또 개수 테스트`() {
        assertThat(lottoStaff.countLotto(3000)).isEqualTo(3)
    }
}