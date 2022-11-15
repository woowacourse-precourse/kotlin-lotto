package lotto

import lotto.domain.LottoStaff
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoStaffTest {
    private lateinit var lottoStaff: LottoStaff
    private lateinit var lottoNumbers: List<Int>
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0

    @BeforeEach
    fun setUp() {
        lottoStaff = LottoStaff()
        winningNumbers = listOf<Int>(1,2,3,4,5,6)
        lottoNumbers = listOf<Int>(3,5,7,9,11,13)
        bonusNumber = 3
    }

    @Test
    fun `구매 금액에 따른 로또 개수 테스트`() {
        assertThat(lottoStaff.countLotto(3000)).isEqualTo(3)
    }

    @Test
    fun `몇개 번호 일치하는지 확인하는 테스트`(){
        assertThat(lottoStaff.countMatchingNumber(lottoNumbers,winningNumbers)).isEqualTo(2)
    }

    @Test
    fun `보너스 번호가 일치하는지 확인하는 테스트`(){
        assertThat(lottoStaff.checkBonusNumber(lottoNumbers,bonusNumber)).isTrue
    }

    @Test
    fun `수익률 확인하는 기능 테스트`(){
        assertThat(lottoStaff.getProfit(5000,10000)).isEqualTo(50.0)
    }



}