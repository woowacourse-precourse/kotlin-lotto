package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CommonTest {
    @Test
    fun `당첨 번호가 6개가 아닌 경우`(){
        assertThrows<IllegalArgumentException> {
            lottoWinningNumber("1,2,3,4,5,6,7,8")
        }
    }

    @Test
    fun `보너스 번호가 올바르지 않은 경우`(){
        assertThrows<IllegalArgumentException> {
            lottoBonusNumber(listOf(1,2,3,4,5,6), "0")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 겹치는 경우`(){
        assertThrows<IllegalArgumentException> {
            lottoBonusNumber(listOf(1,2,3,4,5,6), "3")
        }
    }

    @Test
    fun `수익률을 구할 때 로또 구입금과 수익금 중 하나를 입력하지 않은 경우`(){
        assertThrows<IllegalArgumentException> {
            earningsRatio(5000, "".toInt())
        }
        assertThrows<IllegalArgumentException> {
            earningsRatio("".toInt(), 5000)
        }
    }
}