package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.domain.LottoWin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat

class LottoWinTest {
    @Test
    fun `당첨 내역을 출력한다`() {
        val result = LottoWin(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))), Lotto(listOf(1, 2, 3, 4, 5, 6)), 7).findLottoWin()
        assertThat(result).isEqualTo(listOf(0,0,0,0,1))
    }

}