package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.Constants

class RuleTest {

    @Test
    fun `구입 금액 숫자 외 문자일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkPurchaseAmount("100a")
        }
    }
    @Test
    fun `구입 금액 숫자가 1000원 단위가 아닐 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkPurchaseAmount("1001")
        }
    }

    // 당첨 번호 체크
    @Test
    fun `사용자가 입력한 당첨번호가 올바르게 입력함`() {
        assertThat(Rule().checkWinningNumbers(listOf("1","2","3","4","5","6")))
    }
    @Test
    fun `사용자가 입력한 당첨번호가 중복일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkWinningNumbers(listOf("1","2","3","4","5","5"))
        }
    }
    @Test
    fun `사용자가 입력한 당첨번호가 주어진 개수보다 많이 입력했을 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkWinningNumbers(listOf("1","2","3","4","5","6","7"))
            Rule().checkWinningNumbers(listOf("1","2","3","4","5"))
        }
    }
    @Test
    fun `사용자가 입력한 당첨번호가 1-45 범위에서 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkWinningNumbers(listOf("1","2","3","4","5","46"))
        }
    }

    // 보너스 번호 체크
    fun `보너스 번호를 올바르게 입력함`() {
        assertThat(Rule().checkBonusNumber(listOf(1,2,3,4,5,6), 7))
    }
    fun `보너스 번호가 당첨 번호와 중복됐을 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkBonusNumber(listOf(1,2,3,4,5,6), 5)
        }
    }
    fun `보너스 번호가 1-45범위에서 벗어날 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Rule().checkBonusNumber(listOf(1,2,3,4,5,6), 99)
        }
    }
}